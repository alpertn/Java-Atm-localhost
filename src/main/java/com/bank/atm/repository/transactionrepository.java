package com.bank.atm.repository;

import com.bank.atm.models.transaction;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class transactionrepository {

    private final JdbcTemplate jdbctemplate;


    public transactionrepository(JdbcTemplate jdbctemplategelen){

        jdbctemplate = jdbctemplategelen;
    }

    private final RowMapper<transaction> rowmapper = (resultset , rownumber) ->{

        transaction transactiondata = new transaction();

        transactiondata.belirle_id(resultset.getLong("id"));
        transactiondata.belirle_gondereniban(resultset.getString("gondereniban"));
        transactiondata.belirle_gonderileniban(resultset.getString("gonderileniban"));
        transactiondata.belirle_islemtutari(resultset.getDouble("bakiye"));
        transactiondata.belirle_transfertarihi(resultset.getTimestamp("transfertarihi").toLocalDateTime());
        return transactiondata;
    };

    public transaction transactionkaydet(transaction transactiondata){

        var tosql = "INSERT INTO transaction (gondereniban,gonderileniban,islemtutari,transfertarihi) VALUES (?,?,?,?)";

        jdbctemplate.update(tosql,transactiondata.cek_gondereniban(),transactiondata.cek_gonderilen(),transactiondata.cek_islemtutari(),transactiondata.cek_transvertarihi());

        return transactiondata;

    }

    public Optional<transaction> idsorgu(Long gelenid){ // optional yazmamızın nedeni eğer değer yok ise hata vermemesi.

        var tosql = "SELECT * FROM transaction WHERE id = ?";

        var sql = jdbctemplate.query(tosql , rowmapper,gelenid).stream().findFirst();

        return sql; // eğer idye bir şey atanmamıssa sonuc.isEmpty() yazarka bulabılırız.

    }

    public Optional<transaction> ibanparagondermesorgu(String iban){

        var tosql = "Select * FROM transaction WHERE gondereniban = ?";

        var sql = jdbctemplate.query(tosql , rowmapper, iban).stream().findFirst();

        return sql;
    }

    public Optional<transaction> gonderilenibansorgu(String iban){


        var tosql = "SELECT * FROM transaction WHERE gonderileniban = ?";

        var sql = jdbctemplate.query(tosql , rowmapper , iban).stream().findFirst();

        return sql;

    }

}

