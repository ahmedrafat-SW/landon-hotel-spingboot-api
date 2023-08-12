package com.dev.landonhotelapi.controller;

import com.dev.landonhotelapi.data.Reservation;
import com.dev.landonhotelapi.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/reservations")
@AllArgsConstructor
public class ReservationController {

    private final ReservationRepository repository;


    @GetMapping
    public Iterable<Reservation> getAllReservations(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation){
        return repository.save(reservation);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteReservation(@PathVariable Long id){
        repository.delete(repository.findById(id).get());
    }
}
