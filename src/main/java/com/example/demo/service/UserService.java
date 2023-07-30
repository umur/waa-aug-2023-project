package com.example.demo.service;

import com.example.demo.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);
    public List<UserDto> getAll();
    UserDto getById(int id);
    UserDto update(UserDto userDto, int id);
    boolean delete(int id);
}
