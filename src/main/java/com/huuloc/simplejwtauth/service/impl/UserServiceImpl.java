package com.huuloc.simplejwtauth.service.impl;

import com.huuloc.simplejwtauth.dto.UserDto;
import com.huuloc.simplejwtauth.dto.mapper.UserMapper;
import com.huuloc.simplejwtauth.entity.User;
import com.huuloc.simplejwtauth.repository.UserRepository;
import com.huuloc.simplejwtauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private final UserMapper mapper = UserMapper.INSTANCE;

    @Override
    public List<UserDto> findAll() {
        return mapper.entityList2DtoList(
                userRepository.findAll()
        );
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow();
        return mapper.entity2Dto(user);
    }

    @Override
    public UserDto save(UserDto userDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void createTestingData() {

    }
}
