package com.forfun.springdata.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.StringJoiner;

@Entity
@Data
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    private String number;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Phone.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("number='" + number + "'")
                .toString();
    }
}
