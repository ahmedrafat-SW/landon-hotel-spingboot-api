package com.dev.landonhotelapi.controller.viewcontroller;

import com.dev.landonhotelapi.business.ReservationService;
import com.dev.landonhotelapi.business.RoomReservation;
import com.dev.landonhotelapi.utils.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//@RestController
@Controller
@RequestMapping(path = "/reservations")
@AllArgsConstructor
public class ReservationViewController {

    private final ReservationService reservationService;
    private final DateUtils dateUtils;



    @GetMapping
    public String getAllReservations(@RequestParam(value = "date", required = false) String dateString, Model model){

        Date date = dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = reservationService.getAllRoomReservationsWithDate(date);

        model.addAttribute("roomReservations", roomReservations);

        return "/roomres";

    }

}
