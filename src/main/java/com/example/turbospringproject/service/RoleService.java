package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.RoleRepository;
import com.example.turbospringproject.mapper.RoleMapper;
import com.example.turbospringproject.model.auth.RoleDto;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void saveRole(RoleDto roleDto) {
        roleRepository.save(RoleMapper.mapper.mapDtoToEntity(roleDto));
    }

}
