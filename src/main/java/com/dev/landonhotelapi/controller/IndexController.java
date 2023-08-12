package com.dev.landonhotelapi.controller;

import com.dev.landonhotelapi.data.Room;
import com.dev.landonhotelapi.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class IndexController {

    private final RoomRepository roomRepository;
    @GetMapping("/")
    public String index(Model model) {
        List<Room> rooms = new ArrayList<>();
        rooms.addAll(roomRepository.findAll());

        model.addAllAttributes(rooms);

        // return view name
        return "index";
    }

}