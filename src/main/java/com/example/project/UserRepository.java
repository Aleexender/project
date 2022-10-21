package com.example.project;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class UserRepository {

   private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    public UserModel getUser(String id){
        UserModel userModel = new UserModel();
        jdbcTemplate.query("SELECT * FROM user WHERE id = '" + id + "'", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException, DataAccessException {
                userModel.setId(rs.getString("id"));
                userModel.setNickname(rs.getString("nickname"));
                userModel.setPassword( rs.getString("password"));
            }
        });
        return userModel;

    }

}
