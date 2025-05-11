package com.bank.atm.repository;

import com.bank.atm.models.transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class transactionrepository {

    private final JdbcTemplate jdbctemplate;


    public transactionrepository(JdbcTemplate jdbctemplategelen){

        this.jdbctemplate = jdbctemplategelen;
    }

    private final RowMapper<transaction> rowmapper = (resultset , rownumber) ->{

        transaction transactiondata = new transaction();

        transactiondata.belirle_id(resultset.getLong("id"));
        transactiondata.belirle_gondereniban(resultset.getString("gondereniban"));
        transactiondata.belirle_gonderileniban(resultset.getString("gonderileniban"));
        transactiondata.belirle_bakiye(resultset.getDouble("bakiye"));
        transactiondata.belirle_transfertarihi(resultset.getTimestamp("transfertarihi").toLocalDateTime());
        return transactiondata;
    };

    public static void transactionkaydet(transaction transactiondata){

        var tosql = "INSERT INTO ";

    }
}
