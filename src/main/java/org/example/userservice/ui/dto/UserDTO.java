package org.example.userservice.ui.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.userservice.domain.model.Enum.Role;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Long userId;

    @Size(max = 128)
    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private Role role;

    private LocalDateTime modifiedAt;

    private List<Long> chatIds;

}