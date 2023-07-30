package com.example.demo.service;

import com.example.demo.dto.UserDto;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);

    public List<UserDto> getAll();
    UserDto getById(int id);
    void update(UserDto userDto, int id);

    void delete(int id);
}
