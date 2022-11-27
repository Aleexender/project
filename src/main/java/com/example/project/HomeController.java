package com.example.project;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping(path = "/home")
    public String helloWorld(){
        return "home";
    }
}
