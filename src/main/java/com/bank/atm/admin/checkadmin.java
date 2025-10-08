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

        String tosql = "select  COUNT(*) from admin WHERE adminname = ? AND adminpassword = ?";

        var jdbctemplate = jdbcTemplate.queryForObject(tosql,Integer.class ,name,password);

        if (jdbctemplate == null && jdbctemplate < 0){
            return false;
        }else{
            return true;
        }

    }


}


//http://localhost:8080/api/admin/updatebalancewithiban
