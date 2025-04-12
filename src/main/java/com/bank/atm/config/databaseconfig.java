package com.bank.atm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class databaseconfig {

    @Bean
    public DataSource DataSource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3399/atm_db?useSSL=false"); // database baglantısı
        datasource.setUsername("root");
        datasource.setPassword("root");
        return datasource;

//        use atm;
//        CREATE TABLE User(
//                id BIGINT AUTO_INCREMENT PRIMARY KEY,
//                ad varchar(50),
//                soyad varchar(50),
//                sifre varchar(50),
//                iban varchar(26),
//                tckimlikno varchar(11),
//                dogumtarihi DATE,
//                bakiye DECIMAL(99,2) DEFAULT 0.00
//);

}
