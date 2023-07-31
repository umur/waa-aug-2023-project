package com.example.demo.service;

import com.example.demo.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);
    public List<UserDto> getAll();
    UserDto getById(long id);
    UserDto update(UserDto userDto, long id);
    boolean delete(long id);
}
