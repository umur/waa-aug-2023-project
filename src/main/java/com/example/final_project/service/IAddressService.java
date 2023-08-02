package com.example.final_project.service;
import com.example.final_project.dto.AddressDto;
import com.example.final_project.entity.Address;

import java.util.List;

public interface IAddressService {
    void add(AddressDto address);
    List<AddressDto> findAll();
    AddressDto findById(Long id);
    void updateAddress(AddressDto address, Long id);
    void deleteAddress(Long id);
}
