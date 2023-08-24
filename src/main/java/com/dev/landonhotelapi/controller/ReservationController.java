package com.dev.landonhotelapi.controller;

import com.dev.landonhotelapi.data.Reservation;
import com.dev.landonhotelapi.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/reservations")
@AllArgsConstructor
public class ReservationController {

    private final ReservationRepository repository;

    @GetMapping
    public Iterable<Reservation> getAllReservations(){
        return repository.findAll();
    }

}
