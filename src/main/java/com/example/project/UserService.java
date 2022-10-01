package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

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

}
