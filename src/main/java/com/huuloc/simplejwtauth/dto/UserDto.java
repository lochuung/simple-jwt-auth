package com.huuloc.simplejwtauth.dto;

import com.huuloc.simplejwtauth.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String birthday;
    private String status;
    private boolean enabled;
    private boolean isUsing2FA;
    private String secret;
    private List<RoleDto> roles;
}
