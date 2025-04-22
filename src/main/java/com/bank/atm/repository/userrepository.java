package com.bank.atm.repository;

import com.bank.atm.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class userrepository {

    private final JdbcTemplate jdbctemplate;

    public userrepository(JdbcTemplate jdbctemplate){ // database islemlerimiz icin jdbctemplate kullanıyoruz.
        this.jdbctemplate = jdbctemplate;

    }



    //RowMapper ile sqlden aldıgımız verileri User Class'ına donusturuyoruz.
    private final RowMapper<User> RowMapperUser = (resultset,rownum) ->{

            User user = new User();

            user.belirle_id(resultset.getLong("id")); // Sqlden ID'yi long olarak alıyor. User class'ında id'yi Long olarak tanımladım.
            user.belirle_isim(resultset.getString("ad"));
            user.belirle_soyad(resultset.getString("soyad"));
            user.belirle_tckn(resultset.getString("tckimlikno"));
            user.belirle_sifre(resultset.getString("password"));
            user.belirle_dogumtarihi(resultset.getDate("dogumtarihi").toLocalDate());
            user.belirle_iban(resultset.getString("iban"));
            user.belirle_bakiye(resultset.getFloat("bakiye"));

            return user; // hazırladıgımız user degiskenini donduruyoruz.

    };

    public User save(User saveuser){

        String tosql = "INSERT INTO Users (ad,soyad,sifre,iban,tckimlikno,dogumtarihi,balance) VALUES (?,?,?,?,?,?,?)"; // Insert ediyoruz.

        jdbctemplate.update(tosql, saveuser.cek_isim(), saveuser.cek_soyad(), saveuser.cek_sifre(), saveuser. cek_iban(),saveuser.cek_tckn(),saveuser.cek_dogumtarihi(),saveuser.cek_bakiye());

        return saveuser;
    };



}
