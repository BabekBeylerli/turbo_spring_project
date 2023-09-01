package com.example.turbospringproject.service;

import com.example.turbospringproject.dao.entity.UserEntity;
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

    public List<UserDto> getAllUser() {
        log.info("ActionLog.getAllUser.start");
        List<UserDto> userDtos = UserMapper.mapper.mapEntityToDtos(userRepository.findAll());
        log.info("ActionLog.getAllUser.end");
        return userDtos;
    }

    public UserDto getUser(Integer userId) {
        log.info("ActionLog.getUser.start");
        UserEntity userEntity =
                userRepository.findById(userId).orElseThrow(() ->
                        new RuntimeException("Not Found")
                );
        log.info("ActionLog.getUser.end");
        return UserMapper.mapper.mapEntityToDto(userEntity);
    }

    public void saveUser(UserDto userDto) {
        log.info("ActionLog.saveUser.start");
        userRepository.save(UserMapper.mapper.mapDtoToEntity(userDto));
        log.info("ActionLog.saveUser.end");
    }

    public void editUser(UserDto userDto, Integer userId) {
        log.info("ActionLog.editUser.start");
        userRepository.save(UserMapper.mapper.mapDtoToEntity(userDto, userId));
        log.info("ActionLog.editUser.end");
    }

    public void deleteUser(Integer userId) {
        log.info("ActionLog.deleteUser.start");
        userRepository.deleteById(userId);
        log.info("ActionLog.deleteUser.end");
    }


}
