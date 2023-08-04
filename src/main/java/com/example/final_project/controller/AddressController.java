package com.example.final_project.controller;
import com.example.final_project.dto.AddressDto;
import com.example.final_project.dto.ResponseMessage;
import com.example.final_project.service.imp.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<ResponseMessage> add(@RequestBody AddressDto address){
        System.out.println("address");
        addressService.add(address);
        return ResponseEntity.ok(new ResponseMessage(true,"successfully added address"));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> update(@RequestBody AddressDto address, @PathVariable Long id){
        addressService.updateAddress(address,id);
        return ResponseEntity.ok(new ResponseMessage(true,"successfully updated address"));
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Object> delete(@PathVariable Long id){
        addressService.deleteAddress(id);
        return ResponseEntity.ok(new ResponseMessage(true,"removed correctly"));
    }
    @GetMapping
        public List<AddressDto> get(){
        return addressService.findAll();
    }
    @GetMapping("/{id}")
    public AddressDto getById(@PathVariable Long id){
        return addressService.findById(id);
    }
}
