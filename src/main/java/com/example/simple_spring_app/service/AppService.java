package com.example.simple_spring_app.service;

import com.example.simple_spring_app.dto.Response;
import com.example.simple_spring_app.entity.Address;
import com.example.simple_spring_app.entity.Person;
import com.example.simple_spring_app.repository.AddressRepository;
import com.example.simple_spring_app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Response addPerson(Person person) {
        personRepository.save(person);
        return Response.builder()
                .status(200)
                .message("Person added successfully!")
                .build();
//                .data(person);
    }

    public Response getPerson() {
        return Response.builder()
                .status(200)
                .message("Person retrieved successfully!")
                .data(personRepository.findAll())
                .build();
    }

    public Response addAddress(Long personId, Address address) {
        Person person = personRepository.findById(personId).orElse(null);
        if (person == null) {
            return Response.builder()
                    .status(404)
                    .message("Person not found!")
                    .build();
        }
        address.setPerson(person);
        addressRepository.save(address); // set the person to the address, and save the address, it will automatically save the person
        return Response.builder()
                .status(200)
                .message("Address added successfully!")
                .build();
    }

    public Response getAddress() {
        return Response.builder()
                .status(200)
                .message("Address retrieved successfully!")
                .data(addressRepository.findAll())
                .build();
    }

    public Response deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address == null) {
            return Response.builder()
                    .status(404)
                    .message("Address not found!")
                    .build();
        }
        addressRepository.delete(address);
        return Response.builder()
                .status(200)
                .message("Address deleted successfully!")
                .build();
    }

    public Response deletePerson(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person == null) {
            return Response.builder()
                    .status(404)
                    .message("Person not found!")
                    .build();
        }
        personRepository.delete(person); // delete person will delete all the addresses associated with it, since it is orphanRemoval = true
        return Response.builder()
                .status(200)
                .message("Person deleted successfully!")
                .build();
    }

    public Object addSamplePerson() {
        Person person = Person.builder()
                .name("John Doe")
                .build();

        Address address1 = Address.builder()
                .city("New York")
                .country("USA")
                .person(person)
                .build();

        Address address2 = Address.builder()
                .city("London")
                .country("UK")
                .person(person)
                .build();

        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);

        person.setAddress(addresses);

        personRepository.save(person); // save person will save all the addresses associated with it, since it is cascade = CascadeType.ALL

        return Response.builder()
                .status(200)
                .message("Person added successfully!")
                .data(person)
                .build();
    }
}
