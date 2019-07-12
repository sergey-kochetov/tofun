package com.forfun.springdata.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "passport")
@Data
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String number;

    @OneToOne(mappedBy = "passport", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.DETACH
    })
    private Person person;

    public Passport(String s) {
        this.number = s;
    }

    public Passport() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Passport.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("number='" + number + "'")
                .add("person=" + person)
                .toString();
    }
}
