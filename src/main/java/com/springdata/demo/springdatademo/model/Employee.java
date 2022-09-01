package com.springdata.demo.springdatademo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" ,length = 30)
    private String name;

    @Column(name = "surname" ,length = 30)
    private String surname;

    private int age;

    private double salary;

    @OneToOne(mappedBy = "employee")
    private Address address;
}
