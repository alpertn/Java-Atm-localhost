package com.bank.atm.repository;

import com.bank.atm.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public class userrepository {


    public static JdbcTemplate jdbctemplate;

    public userrepository(JdbcTemplate jdbctemplate){ // database islemlerimiz icin jdbctemplate kullanıyoruz.
        this.jdbctemplate = jdbctemplate;

    }



    //RowMapper ile sqlden aldıgımız verileri User Class'ına donusturuyoruz.
    private static final RowMapper<User> RowMapperUser = (resultset, rownum) ->{

        User user = new User();

        user.setid(resultset.getLong("id")); // Sqlden ID'yi long olarak alıyor. User class'ında id'yi Long olarak tanımladım.
        user.setname(resultset.getString("ad"));
        user.setsurname(resultset.getString("soyad"));
        user.settckn(resultset.getString("tckimlikno"));
        user.setpassword(resultset.getString("password"));
        user.setbirthdate(resultset.getDate("dogumtarihi").toLocalDate());
        user.setiban(resultset.getString("iban"));
        user.setbalance(resultset.getFloat("balance"));

        return user; // hazırladıgımız user degiskenini donduruyoruz.

    };

    // User türünde bir modül olusturduk. Save modülü User tipinde veri alıyor. sql stringi hazırladık. jdbctemplate ile ? yazılan yerlere user değişkeninin icindekileri aktardık.
    public User save(User saveuser){

        String tosql = "INSERT INTO User (ad,soyad,password,iban,tckimlikno,dogumtarihi,balance) VALUES (?,?,?,?,?,?,?)"; // Insert ediyoruz.

        jdbctemplate.update(tosql, saveuser.getname(), saveuser.getsurname(), saveuser.getpassword(), saveuser.getiban(),saveuser.gettckn(),saveuser.getbirthdate(),saveuser.getbalance());

        return saveuser;
    };

    public static Optional<User> idsorgu(Long  gelenid){ // user olarak donduruoruz.

        String tosql = "SELECT * FROM User WHERE id = ?";
        var sql = jdbctemplate.query(tosql, RowMapperUser, gelenid).stream().findFirst(); // .stream() kullanmayınca .findFirst() gibi methodları kullanamıyoruz. sql kodunu gönderiyor. veriyi rowmapper'e kaydediyor. ? diye bıraktıgımızı da id ile degistiriyor.

        return sql; // sqlden gelen veriyi donduruyoruz.
    }

    public Boolean DeleteUser(Long id){

        String tosql = "DELETE FROM USER WHERE id = ?";

        var sql = jdbctemplate.update(tosql , id);

        if (sql > 0){

            return true;

        }else {

            return false;

        }

    }

    public Boolean Updatebakiye(float yenibakiye, String id){

        String tosql = "UPDATE user SET balance = ? WHERE id = ?";

        var sql = jdbctemplate.update(tosql, yenibakiye,id);

        if (sql > 0){
            return true;
        }else{
            return false;
        }



    }

    public Boolean updatebalancewithiban(float yenibakiye, String iban){

        String tosql = "UPDATE user SET balance = ? WHERE iban = ?";

        var sql = jdbctemplate.update(tosql, yenibakiye,iban);

        if (sql > 0){
            return true;
        }else{
            return false;
        }



    }

    public Long findid(){

        String tosql = "SELECT MAX(id) AS max_id FROM user;";

        var id = jdbctemplate.queryForObject(tosql, Long.class);
        if (id ==null ){ // databasede verı olmayınca hata verıyor oyuzden +1 ypamak zorunlu
            return 1L;
        }

        return id;



    }

    public Optional<User> findbyiban(String iban){

        var tosql = "SELECT * FROM USER WHERE iban = ?" ;

        var ibann = jdbctemplate.query(tosql, RowMapperUser).stream().findFirst();
        return ibann;


    }

    public static Optional<User> findaccountbyiban(String iban){

        String tosql = "SELECT * FROM User WHERE iban = ?";
        Optional<User> user = jdbctemplate.query(tosql, RowMapperUser, iban).stream().findFirst();

        return user;
    }

    public String findbyiban2(String iban){

        var tosql = "SELECT id FROM user WHERE iban = ?" ;

        var ibann = jdbctemplate.queryForObject(tosql, String.class, iban).toString();
        return ibann;


    }





}

