package com.dev.landonhotelapi.business;

import com.dev.landonhotelapi.data.Guest;
import com.dev.landonhotelapi.data.Reservation;
import com.dev.landonhotelapi.data.Room;
import com.dev.landonhotelapi.repository.GuestRepository;
import com.dev.landonhotelapi.repository.ReservationRepository;
import com.dev.landonhotelapi.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.*;
//import java.sql.Date;

@Service
public class ReservationService {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(RoomRepository roomRepository,
                              GuestRepository guestRepository,
                              ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getAllRoomReservationsWithDate(Date date){
        List<Room> rooms  = roomRepository.findAll();

        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room ->{
            RoomReservation reservation = new RoomReservation();
            reservation.setRoomId(room.getRoomId());
            reservation.setRoomName(room.getRoomName());
            reservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(),reservation);
        });

        Iterable<Reservation> reservations = this.reservationRepository
                .findReservationByReservationDate(date);
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getId());
        });
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }
        roomReservations.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation o1, RoomReservation o2) {
                if (o1.getRoomName().equals(o2.getRoomName())) {
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomName().compareTo(o2.getRoomName());
            }
        });
        return roomReservations;
    }


    public List<Guest> getAllGuestsByState(String state){
        List<Guest> guests = guestRepository.findAllGuestsByState(state);

        guests.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                if(o1.getState().equals(o2.getState())){
                    return o1.getCountry().compareTo(o2.getCountry());
                }
                return o1.getState().compareTo(o2.getState());
            }
        });

        return guests;
    }
}
