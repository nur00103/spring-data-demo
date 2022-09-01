package com.springdata.demo.springdatademo.service;

import com.springdata.demo.springdatademo.model.Address;
import com.springdata.demo.springdatademo.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public void insert(Address address){
        addressRepository.save(address);
    }
}
