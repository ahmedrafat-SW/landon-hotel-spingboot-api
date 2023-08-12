package com.dev.landonhotelapi.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GUEST")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Guest {
//GUEST_ID  	FIRST_NAME  	LAST_NAME  	EMAIL_ADDRESS  	ADDRESS  	COUNTRY  	STATE  	PHONE_NUMBER
    @Column(name = "GUEST_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL_ADDRESS")
    private String email;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "STATE")
    private String state;
    @Column(name = "PHONE_NUMBER")
    private String phone;
}
