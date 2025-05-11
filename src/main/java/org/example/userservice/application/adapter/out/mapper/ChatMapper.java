package org.example.userservice.application.adapter.out.mapper;

import org.example.userservice.domain.model.ChatEntity;
import org.example.userservice.domain.model.MessageEntity;
import org.example.userservice.domain.model.UserEntity;
import org.example.userservice.ui.dto.ChatDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChatMapper {

    private final UserMapper userMapper;
    private final MessageMapper messageMapper;

    public ChatMapper(UserMapper userMapper, MessageMapper messageMapper) {
        this.userMapper = userMapper;
        this.messageMapper = messageMapper;
    }

    public ChatDTO toDto(ChatEntity entity) {
        if (entity == null) {
            return null;
        }
        ChatDTO dto = new ChatDTO();
        dto.setChatId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setUserId(entity.getUser().getId());
        if (entity.getMessages() != null) {
            dto.setMessageIds(entity.getMessages().stream().map(MessageEntity::getId).collect(Collectors.toList()));
        }
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setModifiedAt(entity.getModifiedAt());
        return dto;
    }

    public ChatEntity toEntity(ChatDTO dto) {
        if (dto == null) {
            return null;
        }
        ChatEntity entity = new ChatEntity();
        entity.setTitle(dto.getTitle());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setModifiedAt(dto.getModifiedAt());
        return entity;
    }
}