package org.example.userservice.ui.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.userservice.domain.model.Enum.Role;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessageDTO {

    private Long messageId;

    @NotNull
    @JsonProperty("sender")
    private Role role;

    @NotNull
    @JsonProperty("content")
    @Size(min = 1, max = 3000)
    private String message;

    @NotNull
    private Long chatId;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    public MessageDTO(
            Long id,
            String message,
            Role role,
            Long chatId
    ) {
        this.messageId = id;
        this.message = message;
        this.role = role;
        this.chatId = chatId;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    public MessageDTO() {}
}
