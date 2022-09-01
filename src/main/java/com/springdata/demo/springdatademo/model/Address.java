package com.springdata.demo.springdatademo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String city;

    @OneToOne
    private Employee employee;
}
