package com.dev.landonhotelapi.utils;

import com.dev.landonhotelapi.business.ReservationService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public ApplicationEvent(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
//        Date date = dateUtils.createDateFromDateString("2022-01-01");
//        List<RoomReservation> reservations = reservationService.getAllRoomReservationsWithDate(date);
//        reservations.forEach(System.out::println);
    }


}
