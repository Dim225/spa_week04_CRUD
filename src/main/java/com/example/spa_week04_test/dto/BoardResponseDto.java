package com.example.spa_week04_test.dto;

import com.example.spa_week04_test.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String title;
    private String username;
    private String content;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public BoardResponseDto(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.password = board.getPassword();
        this.content = board.getContent();
        this.username = board.getUsername();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }
}