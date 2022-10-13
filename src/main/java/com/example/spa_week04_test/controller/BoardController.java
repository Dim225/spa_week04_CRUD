package com.example.spa_week04_test.controller;

import com.example.spa_week04_test.dto.BoardListResponseDto;
import com.example.spa_week04_test.dto.BoardRequestDto;
import com.example.spa_week04_test.dto.BoardResponseDto;
import com.example.spa_week04_test.dto.PasswordRequestDto;
import com.example.spa_week04_test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board")
    public List<BoardListResponseDto> getlist() {
        return boardService.findAllBoard();
    }

    @PostMapping("/board")
    public BoardResponseDto createlist(@RequestBody BoardRequestDto requestDto){
        return boardService.save(requestDto);
    }

    @GetMapping("/board/{id}")
    public BoardResponseDto getdetail(@PathVariable Long id){
        return boardService.getDetail(id);
    }

    @PostMapping("/board/{id}")
    public BoardResponseDto chechpw(@PathVariable Long id, @RequestBody PasswordRequestDto requestDto){
        return boardService.checkpw(id, requestDto);
    }

    @PutMapping("/board/{id}")
    public BoardResponseDto updatelist(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/board/{id}")
    public BoardResponseDto deletelist(@PathVariable Long id){
        return boardService.delete(id);
    }
}
