package com.huuloc.simplejwtauth.service;

import com.huuloc.simplejwtauth.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto save(UserDto userDto);

    void delete(Long id);
    void createTestingData();
}
