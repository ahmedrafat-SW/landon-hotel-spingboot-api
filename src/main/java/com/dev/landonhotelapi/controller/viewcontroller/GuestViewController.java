package com.dev.landonhotelapi.controller.viewcontroller;

import com.dev.landonhotelapi.business.ReservationService;
import com.dev.landonhotelapi.data.Guest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/guests")
@AllArgsConstructor
public class GuestViewController {

    private final ReservationService service;
    @GetMapping

    public String getAllGuests(@RequestParam(value = "state", required = false) String state, Model model){

        List<Guest> guests = service.getAllGuestsByState(state);
        model.addAttribute("guests", guests);

        return "/guests";
    }
}
