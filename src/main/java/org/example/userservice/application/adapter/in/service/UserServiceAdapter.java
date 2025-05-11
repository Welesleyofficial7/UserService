package org.example.userservice.application.adapter.in.service;

import org.example.userservice.application.adapter.out.mapper.UserMapper;
import org.example.userservice.domain.model.Enum.Role;
import org.example.userservice.domain.model.UserEntity;
import org.example.userservice.infrastructure.repository.UserRepository;
import org.example.userservice.ui.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceAdapter {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public UserServiceAdapter(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO createUser(UserDTO userDto) {
        UserEntity userEntity = userMapper.toEntity(userDto);
        if (userEntity.getRole() == null ) {
            userEntity.setRole(Role.USER);
        }
        UserEntity savedEntity = userRepository.save(userEntity);
        return userMapper.toDto(savedEntity);
    }

    public UserDTO getUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        return userEntity != null ? userMapper.toDto(userEntity) : null;
    }

    public UserDTO getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return userEntity != null ? userMapper.toDto(userEntity) : null;
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(userMapper::toDto).collect(Collectors.toList());
    }
}
