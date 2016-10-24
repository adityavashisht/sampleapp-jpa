package com.indasil.sampleapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vashishta on 10/17/16.
 */
@Data
@Entity
@Table(name="PERSON")
public class Person {

    @Id
    @SequenceGenerator(name="person_seq_generator",
            sequenceName="person_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="person_seq_generator")
    @Column(name = "person_id", updatable=false)
    private Long id;

    @Column(name="first_name")
    private String name;

    @Column(name="dob")
    Date dob;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
