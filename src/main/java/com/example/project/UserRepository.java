package com.example.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    Set<String> ids;

    public boolean addUser(String id){
        jdbcTemplate.execute("INSERT INTO user (id) VALUES ('" + id + "')");
        ids.add(id);
        return true;
    }
}
