package com.example.spa_week04_test.entity;

import com.example.spa_week04_test.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity

public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 10, nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String content;

    @Column(length = 100, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    public Board(String title, String username, String content, String password) {
        this.title = title;
        this.username = username;
        this.content = content;
        this.password = password;
    }

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();

    }

    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();

    }
}
