package com.dev.landonhotelapi.controller;

import com.dev.landonhotelapi.data.Guest;
import com.dev.landonhotelapi.repository.GuestRepository;
import jakarta.persistence.metamodel.Bindable;
import jakarta.persistence.metamodel.EntityType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/guests")
@AllArgsConstructor
public class GuestController {

    private final GuestRepository repository;


    @GetMapping
    public Iterable<Guest> getAllGuests(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Guest> getGuestById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping
    public Guest saveGuest(@RequestBody Guest guest){
        return repository.save(guest);
    }

    @PutMapping(path = "/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateGuest(@PathVariable Long id, @RequestBody Guest guest){
        repository.findById(id).ifPresent(g -> {
            g.setEmail(guest.getEmail());
            g.setCountry(guest.getCountry());
            g.setState(guest.getState());
            g.setPhone(guest.getPhone());
        });
    }


    @DeleteMapping(path = "/delete/{id}")
    public void deleteGuest(@PathVariable Long id){
        repository.delete(repository.findById(id).get());
    }
}
