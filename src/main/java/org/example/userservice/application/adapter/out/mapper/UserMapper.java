package org.example.userservice.application.adapter.out.mapper;

import org.example.userservice.domain.model.ChatEntity;
import org.example.userservice.domain.model.UserEntity;
import org.example.userservice.ui.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDTO toDto(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setUserId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());
        dto.setModifiedAt(entity.getModifiedAt());
        if (entity.getChats() != null) {
            dto.setChatIds(entity.getChats().stream().map(ChatEntity::getId).collect(Collectors.toList()));
        }
        return dto;
    }

    public UserEntity toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());
        entity.setModifiedAt(dto.getModifiedAt());
        return entity;
    }
}