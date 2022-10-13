package com.example.spa_week04_test.dto;

import com.example.spa_week04_test.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardListResponseDto {

    private String title;
    private String username;
    private LocalDateTime createdAt;

    public BoardListResponseDto(Board board){
        this.title =board.getTitle();
        this.username = board.getUser().getUsername();
        this.createdAt = board.getCreatedAt();
    }
}
