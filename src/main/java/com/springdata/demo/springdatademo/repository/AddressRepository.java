package com.springdata.demo.springdatademo.repository;

import com.springdata.demo.springdatademo.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
