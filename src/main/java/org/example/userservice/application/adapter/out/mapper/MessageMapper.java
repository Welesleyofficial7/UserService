package org.example.userservice.application.adapter.out.mapper;

import org.example.userservice.domain.model.ChatEntity;
import org.example.userservice.domain.model.MessageEntity;
import org.example.userservice.ui.dto.MessageDTO;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public MessageDTO toDto(MessageEntity entity) {
        if (entity == null) {
            return null;
        }
        MessageDTO dto = new MessageDTO();
        dto.setMessageId(entity.getId());
        dto.setRole(entity.getRole());
        dto.setMessage(entity.getMessage());
        dto.setChatId(entity.getChat().getId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setModifiedAt(entity.getModifiedAt());
        return dto;
    }

    public MessageEntity toEntity(MessageDTO dto) {
        if (dto == null) {
            return null;
        }
        MessageEntity entity = new MessageEntity();
        entity.setRole(dto.getRole());
        entity.setMessage(dto.getMessage());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setModifiedAt(dto.getModifiedAt());
        return entity;
    }
}