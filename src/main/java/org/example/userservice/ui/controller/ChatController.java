package org.example.userservice.ui.controller;

import org.example.userservice.application.adapter.in.service.ChatServiceAdapter;
import org.example.userservice.ui.dto.ChatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatServiceAdapter chatService;

    public ChatController(ChatServiceAdapter chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<ChatDTO> createChat(@RequestBody ChatDTO chatDto) {
        ChatDTO createdChat = chatService.createChat(chatDto);
        return ResponseEntity.ok(createdChat);
    }

    @GetMapping
    public ResponseEntity<List<ChatDTO>> getChatsByUser(@RequestParam Long userId) {
        List<ChatDTO> chats = chatService.getChatsByUser(userId);
        return ResponseEntity.ok(chats);
    }

    @GetMapping("/{chatId}")
    public ResponseEntity<ChatDTO> getChatById(@PathVariable Long chatId) {
        ChatDTO chat = chatService.getChatById(chatId);
        if (chat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(chat);
    }

    @DeleteMapping("/{chatId}")
    public ResponseEntity<Void> deleteChat(@PathVariable Long chatId) {
        chatService.deleteChat(chatId);
        return ResponseEntity.noContent().build();
    }
}