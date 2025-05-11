package org.example.userservice.application.adapter.in.service;

import org.example.userservice.application.adapter.out.mapper.MessageMapper;
import org.example.userservice.domain.model.ChatEntity;
import org.example.userservice.domain.model.MessageEntity;
import org.example.userservice.infrastructure.repository.ChatRepository;
import org.example.userservice.infrastructure.repository.MessageRepository;
import org.example.userservice.ui.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceAdapter {

    private static final Logger log = LoggerFactory.getLogger(MessageServiceAdapter.class);
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private ChatRepository chatRepository;

    public MessageServiceAdapter(MessageRepository messageRepository, MessageMapper messageMapper, ChatRepository chatRepository) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
        this.chatRepository = chatRepository;
    }

    public MessageDTO sendMessage(MessageDTO messageDto) {
        MessageEntity messageEntity = messageMapper.toEntity(messageDto);

        ChatEntity chat = chatRepository.findById(messageDto.getChatId()).orElse(null);
        if (chat == null) {
            log.info(String.valueOf(chat != null));
            return null;
        }
        messageEntity.setChat(chat);
        MessageEntity savedEntity = messageRepository.save(messageEntity);
        return messageMapper.toDto(savedEntity);
    }

    public List<MessageDTO> getMessagesByChat(Long chatId) {
        ChatEntity chat = chatRepository.findById(chatId).orElse(null);
        if (chat == null) {
            return List.of();
        }
        List<MessageEntity> messageEntities = messageRepository.findByChat(chat);
        return messageEntities.stream().map(messageMapper::toDto).collect(Collectors.toList());
    }
}
