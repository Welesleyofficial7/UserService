package org.example.userservice.ui.controller;

import org.example.userservice.application.adapter.in.service.MessageServiceAdapter;
import org.example.userservice.ui.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageServiceAdapter messageService;

    public MessageController(MessageServiceAdapter messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> sendMessage(@RequestBody MessageDTO messageDto) {
        System.out.println(messageDto.getMessage());
        MessageDTO sentMessage = messageService.sendMessage(messageDto);
        return ResponseEntity.ok(sentMessage);
    }

    @GetMapping("/{chatId}")
    public ResponseEntity<List<MessageDTO>> getMessagesByChat(@PathVariable Long chatId) {
        List<MessageDTO> messages = messageService.getMessagesByChat(chatId);
        return ResponseEntity.ok(messages);
    }
}
