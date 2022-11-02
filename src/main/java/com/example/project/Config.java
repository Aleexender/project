package com.example.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class Config { //configuration
    @Bean
    Set<String> ids(){
        return new HashSet<>();
    }

}
