package org.example.userservice.application.adapter.in.service;

import org.example.userservice.application.adapter.out.mapper.ChatMapper;
import org.example.userservice.domain.model.ChatEntity;
import org.example.userservice.domain.model.UserEntity;
import org.example.userservice.infrastructure.repository.ChatRepository;
import org.example.userservice.infrastructure.repository.UserRepository;
import org.example.userservice.ui.dto.ChatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatServiceAdapter {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ChatMapper chatMapper;
    @Autowired
    private UserRepository userRepository;

    public ChatDTO createChat(ChatDTO chatDto) {
        ChatEntity chatEntity = chatMapper.toEntity(chatDto);

        UserEntity user = userRepository.findById(chatDto.getUserId()).orElse(null);
        if (user == null) {
            return null;
        }
        chatEntity.setUser(user);
        ChatEntity savedEntity = chatRepository.save(chatEntity);
        return chatMapper.toDto(savedEntity);
    }

    public List<ChatDTO> getChatsByUser(Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return List.of();
        }
        List<ChatEntity> chatEntities = chatRepository.findByUser(user);
        return chatEntities.stream().map(chatMapper::toDto).collect(Collectors.toList());
    }

    public ChatDTO getChatById(Long chatId) {
        ChatEntity chatEntity = chatRepository.findById(chatId).orElse(null);
        return chatEntity != null ? chatMapper.toDto(chatEntity) : null;
    }

    public void deleteChat(Long chatId) {
        chatRepository.deleteById(chatId);
    }
}
