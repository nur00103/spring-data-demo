package com.springdata.demo.springdatademo.repository;

import com.springdata.demo.springdatademo.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeRepository  extends CrudRepository<Employee,Long> {

    //Sorgudursa mutleq findBy ile baslamalidir ve uygun field name dirse sorgunu spring automatic yerine yetirir.
    List<Employee> findByName(String name);

    List<Employee> findByNameAndSurname(String name,String surname);

    List<Employee> findByNameOrSurname(String name,String surname);

    //select * from employee where age>?
    //List<Employee> findByAgeThanGreater(int age);

    //select * from employee where age>? and salary<?
    //List<Employee> findByAgeThanGreaterAndSalaryThanLess(int age,double salary);

    //@Query("select e from Employee e where e.age>?1 and e.salary<?2")
    //List<Employee> findSomething(int age,double salary);

    //List<Employee> findByOrderOrderByNameAsc();

    //List<Employee> findTop10();

    //Update ve ya Delete sorgularinda @Modifying(clearautomatically=true) annotation istifade edilir

}
