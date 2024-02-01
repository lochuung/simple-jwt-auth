package com.huuloc.simplejwtauth.dto.mapper;

import com.huuloc.simplejwtauth.dto.UserDto;
import com.huuloc.simplejwtauth.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dto2Entity(UserDto userDto);

    UserDto entity2Dto(User user);

    List<User> dtoList2EntityList(List<UserDto> userDtos);

    List<UserDto> entityList2DtoList(List<User> users);
}
