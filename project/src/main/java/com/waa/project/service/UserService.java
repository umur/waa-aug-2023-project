package com.waa.project.service;

import com.waa.project.dto.responseDto.UsersDto;
import com.waa.project.entity.User;

import java.util.List;

public interface UserService {
    List<UsersDto> getUsers();
}
