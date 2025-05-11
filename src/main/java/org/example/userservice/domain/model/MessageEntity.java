package org.example.userservice.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.userservice.domain.model.Enum.Role;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "messages")
@EntityListeners(AuditingEntityListener.class)
@AttributeOverride(name = "id", column = @Column(name = "message_id"))
public class MessageEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", nullable = false)
    private ChatEntity chat;

    @NotNull
    @Size(min = 1, max = 3000)
    private String message;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    public MessageEntity(Role role, ChatEntity chat, String message) {
        this.role = role;
        this.chat = chat;
        this.message = message;
    }
}