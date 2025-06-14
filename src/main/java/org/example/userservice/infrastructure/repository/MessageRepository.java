package org.example.userservice.infrastructure.repository;

import org.example.userservice.domain.model.ChatEntity;
import org.example.userservice.domain.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    List<MessageEntity> findByChat(ChatEntity chat);
}
