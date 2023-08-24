package com.dev.landonhotelapi.repository;

import com.dev.landonhotelapi.data.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest getGuestByEmail(String email);

    List<Guest> findAllGuestsByState(String state);
}
