package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Set<String> ids;

    public boolean addUserLogic(String id) {
        if(!ids.contains(id)){
            return userRepository.addUser(id);
        }
        return false;
    }

}
