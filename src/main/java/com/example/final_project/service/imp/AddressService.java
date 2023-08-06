package com.example.final_project.service.imp;

import com.example.final_project.dto.AddressDto;
import com.example.final_project.entity.Address;
import com.example.final_project.entity.User;
import com.example.final_project.repository.AddressRepo;
import com.example.final_project.repository.UserRepository;
import com.example.final_project.service.IAddressService;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ModelMapper modelMapper;
    public void add(AddressDto address, HttpServletRequest request) {
        String email = (String) request.getAttribute("email");
        User user = userRepo.findUserByEmail(email).get();
        var addressVal = modelMapper.map(address, Address.class);
        addressVal.setUser(user);
        addressRepo.save(addressVal);
    }
    public List<AddressDto> findAll() {
        var addressList = addressRepo.findAllPresent();
        var addressDtoList = new ArrayList<AddressDto>();
        addressList.forEach(add->{
            var data = modelMapper.map(add,AddressDto.class);
            addressDtoList.add(data);
        });
        return addressDtoList;
    }

    public AddressDto findById(Long id) {
        if (addressRepo.findPresentById(id).isPresent()) {
            var address = addressRepo.findPresentById(id).get();
            var addressDto = modelMapper.map(address, AddressDto.class);
            return addressDto;
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public void updateAddress(AddressDto address, Long id) {
        if(addressRepo.findPresentById(id).isPresent()) {
            var addressVal = modelMapper.map(address, Address.class);
            addressVal.setId(id);
            addressRepo.save(addressVal);
        }
        else {
            throw new ObjectNotFoundException(id, "Address");
        }

    }
    public void deleteAddress(Long id) {
        if(addressRepo.findPresentById(id).isPresent()) {
            var address = addressRepo.findPresentById(id).get();
            address.setDeleted(true);
            addressRepo.save(address);
        }
        else {
            throw new ObjectNotFoundException(id, "Address");
        }
    }
}
