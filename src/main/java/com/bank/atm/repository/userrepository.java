package com.bank.atm.repository;

import com.bank.atm.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class userrepository {

    private final JdbcTemplate jdbctemplate;

    public userrepository(JdbcTemplate jdbctemplate){ // database islemlerimiz icin jdbctemplate kullanıyoruz.
        this.jdbctemplate = jdbctemplate;

    }



    //RowMapper ile sqlden aldıgımız verileri User Class'ına donusturuyoruz.
    private final RowMapper<User> RowMapperUser = (resultset,rownum) ->{

            User user = new User();

            user.SetId(resultset.getLong("id")); // Sqlden ID'yi long olarak alıyor. User class'ında id'yi Long olarak tanımladım.
            user.SetName(resultset.getString("ad"));
            user.SetSurname(resultset.getString("soyad"));
            user.SetTckimlikno(resultset.getString("tckimlikno"));
            user.setPassword(resultset.getString("password"));
            user.SetBirthdate(resultset.getDate("dogumtarihi").toLocalDate());
            user.SetIban(resultset.getString("iban"));
            user.setbalance(resultset.getFloat("bakiye"));

            return user; // hazırladıgımız user degiskenini donduruyoruz.

    };

    public User save(User saveuser){

        String tosql = "INSERT INTO Users (ad,soyad,sifre,iban,tckimlikno,dogumtarihi,balance) VALUES (?,?,?,?,?,?,?)"; // Insert ediyoruz.

        jdbctemplate.update(tosql, saveuser.getName(),saveuser.getSurname());

        return saveuser;
    };



}
