package com.forfun.springdata.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String houseNumber;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.DETACH
    })
    @JoinColumn(name = "person_id")
    private Person person;

    public Address() {
    }

    public Address(String city) {
        this.city = city;
    }
}
