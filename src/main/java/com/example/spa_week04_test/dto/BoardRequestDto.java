package com.example.spa_week04_test.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class BoardRequestDto {
    private String password;
    private String title;
    private String username;
    private String content;
    private LocalDateTime createdAt;

}
