package com.example.project;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel { //단순하게 인변만 넣은거
    //자바 은닉화 or 캡슐화
    private String id;
    private String nickname;
    private String password;


}
