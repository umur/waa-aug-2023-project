package com.example.final_project.service;

import com.example.final_project.dto.*;
import jakarta.servlet.http.HttpServletRequest;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface UserService {
  AuthenticationResponse register(RegisterRequest registerRequest);

  AuthenticationResponse authenticate(LoginRequest loginRequest);

  UserDto getUser(Long id) throws UserPrincipalNotFoundException;

  List<UserDto> getAll();

  void update(UserUpdate userUpdate, HttpServletRequest request);

  void changePassword(PasswordChangeDto pwdDto, HttpServletRequest request);

  void deActivate(Long id);
}
