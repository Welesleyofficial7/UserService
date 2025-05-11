package org.example.userservice.infrastructure.repository;

import org.example.userservice.domain.model.ChatEntity;
import org.example.userservice.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

    List<ChatEntity> findByUser(UserEntity user);
}
