package com.example.spa_week04_test.controller;

import com.example.spa_week04_test.dto.SignupRequestDto;
import com.example.spa_week04_test.repository.UserRepository;
import com.example.spa_week04_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller

public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    //로그인
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    //회원가입
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    //회원가입 요청 처리
    @PostMapping("/user/signup")
    public ResponseEntity<String> addUser(@Valid @RequestBody SignupRequestDto requestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();
                System.out.println("field: " + field.getField());
                System.out.println("message:" + message);
                sb.append("field: ").append(field.getField());
                sb.append("message: ").append(message);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());

        } else { userService.registerUser(requestDto);

        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
