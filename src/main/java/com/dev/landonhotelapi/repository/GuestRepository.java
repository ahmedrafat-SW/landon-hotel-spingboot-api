package com.dev.landonhotelapi.repository;

import com.dev.landonhotelapi.data.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest getGuestByEmail(String email);
}
