package com.huuloc.simplejwtauth.service.impl;

import com.huuloc.simplejwtauth.entity.Privilege;
import com.huuloc.simplejwtauth.entity.Role;
import com.huuloc.simplejwtauth.entity.User;
import com.huuloc.simplejwtauth.repository.PrivilegeRepository;
import com.huuloc.simplejwtauth.repository.RoleRepository;
import com.huuloc.simplejwtauth.repository.UserRepository;
import com.huuloc.simplejwtauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createTestingData() {
        Privilege privilege1 = privilegeRepository.save(Privilege.builder().name("read").build());
        Privilege privilege2 = privilegeRepository.save(Privilege.builder().name("write").build());
        Privilege privilege3 = privilegeRepository.save(Privilege.builder().name("edit").build());

        Role roleUser = roleRepository.save(Role.builder().name("USER").privileges(Collections.singletonList(privilege1)).build());
        Role roleAdmin = roleRepository.save(Role.builder().name("ADMIN").privileges(Collections.singletonList(privilege2)).build());

        userRepository.save(User.builder().email("user@cnj.vn").password(new BCryptPasswordEncoder(10).encode("123")).roles(Collections.singletonList(roleUser)).build());

        userRepository.save(User.builder().email("admin@cnj.vn").password(new BCryptPasswordEncoder(10).encode("123")).roles(Collections.singletonList(roleAdmin)).build());
    }
}
