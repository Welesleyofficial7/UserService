package org.example.userservice.ui.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ChatDTO {

    private Long chatId;

    @Size(max = 128)
    @NotNull
    private String title;

    @NotNull
    private Long userId;

    private List<Long> messageIds;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
