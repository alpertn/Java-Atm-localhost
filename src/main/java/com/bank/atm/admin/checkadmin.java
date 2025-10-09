package com.bank.atm.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class checkadmin {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


    public Boolean checkadmin(String name, String password){

        String sql = "SELECT COUNT(*) FROM admin WHERE adminname = ? AND adminpassword = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, name, password);

        return count != null && count > 0; //if ile yaptıgımda calısmadı
    }


}


//http://localhost:8080/api/admin/updatebalancewithiban
