package com.example.project;

import org.springframework.stereotype.Service;

@Service// 이클래스 전채를 빈으로 만든다.new연산자 오브젝트
public class UserService {

    // 오브젝트들 끼리 연결
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean addUserLogic(String id) {
        if(userRepository.checkUser(id)){
            return userRepository.addUser(id);
        }
        return false;
    }

    public boolean addUserLogic(UserModel userModel) {
        if(userRepository.checkUser(userModel.getId())){
            return userRepository.addUser(userModel);
        }
        return false;
    }

    public UserModel getUser(String id) {
        return userRepository.getUser(id);
    }


}
