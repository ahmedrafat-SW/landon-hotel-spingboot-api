package com.dev.landonhotelapi.data;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "RESERVATION ")
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class Reservation {
//    RESERVATION_ID ▼	ROOM_ID  	GUEST_ID  	RES_DATE

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    private Long id;
    @Column(name = "ROOM_ID")
    private Long roomId;
    @Column(name = "GUEST_ID")
    private Long guestId;
    @Column(name = "RES_DATE")
    private Date reservationDate;
}
