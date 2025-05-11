package org.example.userservice.ui.dto;

import lombok.Getter;

@Getter
public class GetAllChatsDTO {
    private String name;

    public GetAllChatsDTO() {}

    public void setName(String name) {
        this.name = name;
    }
}
