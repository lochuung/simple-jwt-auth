package com.huuloc.simplejwtauth.dto;

import com.huuloc.simplejwtauth.entity.Privilege;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Long id;
    private String name;
    private List<Privilege> privileges;
}
