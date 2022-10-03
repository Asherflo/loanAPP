package com.asherflo.loanApp.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long addressId;
    private int houseNumber;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
