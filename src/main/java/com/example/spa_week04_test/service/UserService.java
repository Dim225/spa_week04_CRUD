package com.example.spa_week04_test.service;

import com.example.spa_week04_test.dto.SignupRequestDto;
import com.example.spa_week04_test.entity.User;
import com.example.spa_week04_test.entity.UserRoleEnum;
import com.example.spa_week04_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;

@Service

public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupRequestDto requestDto) {
        // ID 중복 확인
        String username = requestDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) throw new IllegalArgumentException("중복된 사용자 ID가 존재합니다.");

        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());
        String email = requestDto.getEmail();

        //사용자 role 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (requestDto.isAdmin()) {
            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        User user = new User(username, password, email, role);
        userRepository.save(user);
    }
}
