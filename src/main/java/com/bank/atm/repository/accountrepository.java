package com.bank.atm.repository;

import com.bank.atm.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class accountrepository {


//    private final JdbcTemplate jdbcTemplate; // databaseconfig.java kodundaki sql'e baglanır. sql ile ilgili olan şeyleri burdan yapabılırız.
//
//    public accountrepository(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//
//    // Rowmapper sql'den gelen verileri cevirmeye yarar.
//    private final RowMapper<User> rowMapper = (rs, rowNum) -> {
//        User user = new User(); // user türünde
//        user.belirle_id(rs.getLong("id")); // sqlde kayıtlı olan id degiskenini LONG olarak alınıyor.
//        user.belirle_isim(rs.getString("name"));
//        user.belirle_soyad(rs.getString("surname"));
//        user.belirle_tckn(rs.getString("tckimlikno"));
//        user.belirle_dogumtarihi(rs.getDate("birth_date").toLocalDate());
//        return user;
//    };
//
//
//    // User türünde bir modül olusturduk. Save modülü User tipinde veri alıyor. sql stringi hazırladık. jdbctemplate ile ? yazılan yerlere user değişkeninin icindekileri aktardık.
//    public User Save(User user){
//        String sql = "INSERT INTO users (name, surname, tckimlikno, birthdate) VALUES (?,?,?,?)";
//
//        jdbcTemplate.update(sql, user.belirle_isim(), user.cek_soyad(), user.belirle_isim(), user.cek_dogumtarihi());
//        return user;
//    }
//
//
//    public Optional<User> findbyid(Long gelenid){
//        String sql = "SELECT * FROM users WHERE ID = ?";
//        return jdbcTemplate.query(sql, rowMapper, gelenid).stream().findFirst(); // .stream() kullanmayınca .findFirst() gibi methodları kullanamıyoruz. sql kodunu gönderiyor. veriyi rowmapper'e kaydediyor. ? diye bıraktıgımızı da id ile degistiriyor.
//    }

}
