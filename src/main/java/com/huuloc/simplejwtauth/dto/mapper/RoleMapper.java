package com.huuloc.simplejwtauth.dto.mapper;

import com.huuloc.simplejwtauth.dto.RoleDto;
import com.huuloc.simplejwtauth.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role dto2Entity(RoleDto roleDto);

    RoleDto entity2Dto(Role role);

    List<Role> dtoList2EntityList(List<RoleDto> roleDtos);

    List<RoleDto> entityList2dtoList(List<Role> roles);
}
