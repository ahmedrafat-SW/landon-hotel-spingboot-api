package com.dev.landonhotelapi.repository;

import com.dev.landonhotelapi.data.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room getRoomsByName(String name);
}
