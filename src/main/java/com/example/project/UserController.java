package com.example.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController{

    @Autowired
    UserService userService ;


    @GetMapping(path = "/create")
    public boolean create(@RequestParam String id){
        return userService.addUserLogic(id);
    }



}
