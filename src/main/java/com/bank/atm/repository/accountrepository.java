package com.bank.atm.repository;

import com.bank.atm.models.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class accountrepository {


    private final JdbcTemplate  jdbctemplate;

    public accountrepository(JdbcTemplate jdbctemplate){ // mysql islemleri icin jdbctempalte
        this.jdbctemplate = jdbctemplate;
    }

    private final RowMapper<Account> rowMapper = (rs , rownum) ->{

        Account account = new Account();
        account.setId(rs.getLong("id"));
        account.setIban(rs.getString("iban"));
        account.setUserId(rs.getLong("user_id"));
        account.setBalance(rs.getDouble("balance"));
        return account;
    };

}
