package com.bank.atm.repository;

import com.bank.atm.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class userrepository {

    private final JdbcTemplate jdbcTemplate;

    public userrepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    //Rowmapper sql'den gelen verileri cevirmeye yarar.
    private final RowMapper<User> rowMapper = (rs, rowNum) -> {
        User user = new User();
        user.SetId(rs.getLong("id")); // id degiskeni LONG olarak alınıyor.
        user.SetName(rs.getString("name"));
        user.SetSurname(rs.getString("surname"));
        user.SetTckimlikno(rs.getString("tckimlikno"));
        user.SetBirthdate(rs.getDate("birth_date").toLocalDate());
        return user;
    };

}
