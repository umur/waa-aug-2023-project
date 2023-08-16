package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    private final ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User newUser = userRepo.save(user);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepo.findAll();
        return userList.stream().map(user ->
                modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto getById(long id) {
        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isEmpty()){
            return null;
        }
        User user = userOptional.get();
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto update(UserDto userDto, long id) {
        if(!userRepo.existsById(id)){
            return null;
        }
        UserDto entityDto = getById(id);
        User user = modelMapper.map(entityDto, User.class);
        if(userDto.getEmail() != null) user.setEmail(userDto.getEmail());
        if(userDto.getFirstName() != null) user.setFirstName(userDto.getFirstName());
        if(userDto.getLastName() != null) user.setLastName(userDto.getLastName());
        if(userDto.getPassword() != null) user.setPassword(userDto.getPassword());

        User updatedUser = userRepo.save(user);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public boolean delete(long id) {
        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isEmpty()){
            return false;
        }
        User user = userOptional.get();
        user.setDeleted(true);
        userRepo.save(user);
        return true;
    }
}
