package com.dev.landonhotelapi.repository;

import com.dev.landonhotelapi.data.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
//    Reservation getReservationByGuestEmail(String email);
}
