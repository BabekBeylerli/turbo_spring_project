package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.repository.UserRepository;
import com.example.turbospringproject.mapper.UserMapper;
import com.example.turbospringproject.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        return UserMapper.mapper.mapEntityToDtos(userRepository.findAll());
    }

    public UserDto getUser(Integer userId) {
        return UserMapper.mapper.mapEntityToDto(userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("Not Found")
        ));
    }

    public void saveUser(UserDto userDto) {
        userRepository.save(UserMapper.mapper.mapDtoToEntity(userDto));
    }

    public void editUser(UserDto userDto, Integer userId) {
        userRepository.save(UserMapper.mapper.mapDtoToEntity(userDto, userId));
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }


}
