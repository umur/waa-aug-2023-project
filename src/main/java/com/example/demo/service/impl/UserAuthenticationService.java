package com.example.demo.service.impl;

import com.example.demo.dto.UserAuthenticationRequestDTO;
import com.example.demo.dto.UserAuthenticationResponseDTO;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.entity.RoleType;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserAuthenticationService {
    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    private ModelMapper modelMapper;


    public UserAuthenticationResponseDTO register(UserAuthenticationRequestDTO userAuthenticationRequestDTO) {
        User user=modelMapper.map(userAuthenticationRequestDTO, User.class);

        if(userAuthenticationRequestDTO.getRole().equalsIgnoreCase("student")){
            user.setRole(RoleType.STUDENT);
        }
        if(userAuthenticationRequestDTO.getRole().equalsIgnoreCase("faculty")){
            user.setRole(RoleType.FACULTY);
        }
        if(userAuthenticationRequestDTO.getRole().equalsIgnoreCase("admin")){
            user.setRole(RoleType.ADMIN);
        }
        user.setPassword(passwordEncoder.encode(userAuthenticationRequestDTO.getPassword()));
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return UserAuthenticationResponseDTO.builder().token(jwtToken).build();
    }

    public UserAuthenticationResponseDTO authenticate(UserLoginDto userLoginDTO) {
        var user = userRepository.findByEmail(userLoginDTO.getEmail());
        if(user.isEmpty()){
            throw new UsernameNotFoundException("user not found");
        }
        User userEntity = user.get(0);
        if(!passwordEncoder.matches(userLoginDTO.getPassword(), userEntity.getPassword())) {
            throw new ArithmeticException();
        }
        var jwtToken = jwtService.generateToken(userEntity);
        return UserAuthenticationResponseDTO.builder().token(jwtToken).user(modelMapper.map(userEntity, UserDto.class)).build();
    }
}
