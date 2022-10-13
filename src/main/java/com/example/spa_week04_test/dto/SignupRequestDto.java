package com.example.spa_week04_test.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class SignupRequestDto {

    @NotBlank(message = "닉네임을 입력해주세요.")
    //@Size(min = 4, max = 12)
    @Pattern(regexp = "[a-zA-Z1-9]{4,12}", message = "닉네임을 영어(대문자 포함)와 숫자를 포함해서 4~12자리 이내로 입력해주세요.")
    private String username;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    //@Size(min = 4)
    @Pattern(regexp = "[a-z1-9]{4,32}", message = "비밀번호를 소문자(대문자 미포함)와 숫자를 포함해서 4~32자리 이내로 입력해주세요.")
    private String password;

    @NotBlank(message = "이메일 주소를 입력해주세요.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    private String email;

    private boolean admin = false;
    private String adminToken = "";

//    public String toString() {
//        return "User{" +
//                "nickname='" + nickname + '\'' +
//                ", password=" + password +
//                ", email='"
//    }
}
