package com.dev.landonhotelapi.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ROOM")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ROOM_NUMBER")
    private String roomNumber;
    @Column(name = "BED_INFO")
    private String bedInfo;
}
