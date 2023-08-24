package com.dev.landonhotelapi.controller;

import com.dev.landonhotelapi.data.Room;
import com.dev.landonhotelapi.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/rooms")
@AllArgsConstructor
public class RoomController {

    @Autowired
    private final RoomRepository repository;

    @GetMapping
    public Iterable<Room> getAllRooms(){

        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Room getRoomById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping
    public Room saveRoom(@RequestBody Room room){
        return repository.save(room);
    }

    @PutMapping(path = "/update/{id}")
    public void updateRoom(@PathVariable Long id, @RequestBody Room room){
        repository.findById(id).ifPresent(r -> {
            r.setRoomName(room.getRoomName());
            r.setBedInfo(room.getBedInfo());
            r.setRoomNumber(room.getRoomNumber());
        });
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteRoom(@PathVariable Long id){
        repository.delete(repository.findById(id).get());
    }

}
