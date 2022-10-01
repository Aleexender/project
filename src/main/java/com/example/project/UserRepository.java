package com.example.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean addUser(String id){
        jdbcTemplate.execute("INSERT INTO user (id) VALUES ('" + id + "')");
        return true;
    }

    public boolean addUser(UserModel userModel){
        jdbcTemplate.execute("INSERT INTO user (id, nickname, password) VALUES " +
                "('" + userModel.getId() + "', '" + userModel.getNickname() + "', '" + userModel.getPassword() + "')");
        return true;
    }




    public boolean checkUser(String id){
        Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM user WHERE id = '" + id + "'", Integer.class);
        return count == 0;
    }
}
