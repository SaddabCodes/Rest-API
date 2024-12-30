package com.sadcode.restapi.service;

import com.sadcode.restapi.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getById(Long id);
    List<UserDto> getAll();
    UserDto updateUser(UserDto user);
    void deleteUser(Long id);
}
