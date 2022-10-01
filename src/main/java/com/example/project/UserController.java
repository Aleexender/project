package com.example.project;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    List<String> list = new ArrayList<>();

    @GetMapping(path = "/name")
    public String helloWorld(){
        list.add("name");
        return "added";
    }

    @GetMapping(path = "/name2")
    public List<String> helloWorld2(){
        return this.list;
    }



}
