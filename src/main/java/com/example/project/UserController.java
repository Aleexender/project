package com.example.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService; // 생성자 주입방식

    UserController(UserService userService){ // 생성자 주입방식
        this.userService = userService;
    }

    @GetMapping(path = "/create")
    public boolean create(@RequestParam String id) {
        return userService.addUserLogic(id);
    }

    //ex ) : http://localhost:8080/user/fullCreate?id=hi3&nickname=blah&password=asdf 접속 사이트
    @GetMapping(path = "/fullCreate")
    public void createUser(@RequestParam String id,
                           @RequestParam String nickname,
                           @RequestParam String password) {
        UserModel userModel = new UserModel(id, nickname, password);
        userService.addUserLogic(userModel);
    }

    @GetMapping(path = "/findUser")
    public UserModel findUser(@RequestParam String id){
        return userService.getUser(id);
    }


}
