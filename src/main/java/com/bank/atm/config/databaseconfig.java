package com.bank.atm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.*;

@Configuration
public class databaseconfig {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    @Bean
    public DataSource DataSource() throws SQLException { // QLException hata vermemesı ıcın

        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3331/atm?useSSL=false"); // database baglantısı. Port 3399.
        datasource.setUsername("root");
        datasource.setPassword("root");


        try (Connection connection = datasource.getConnection()) {
            System.out.println(ANSI_GREEN + "---- Mysql Bağlantısı Başarılı! ----> connection.getMetaData().getURL()" + ANSI_RESET);
            System.out.println( connection.getMetaData().getURL());
        } catch (SQLException e) {
            System.out.println(ANSI_RED + "MySql Bağlantısı Başarısız Oldu. Detaylar: " +  ANSI_RESET + e.getMessage());
        }


        if (!tableExists(datasource.getConnection(),"Usder")){

            try(Statement statement = datasource.getConnection().createStatement()) {

                statement.execute(usertablesql);

                System.out.println(ANSI_GREEN +"User isminde tablo oluşturuldu."+ ANSI_RESET);

            }

        }

        if (!tableExists(datasource.getConnection(),"transaction")){

            try(Statement statement = datasource.getConnection().createStatement()){

                statement.execute(transactiontablesql);

                System.out.println(ANSI_GREEN +"User isminde tablo oluşturuldu."+ ANSI_RESET);

            }

        }


        return datasource;
    }

    private boolean tableExists(Connection connection, String tableName) throws SQLException {

        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(null, null, tableName, null);
        return resultSet.next(); // varmı yokmu onu test ediyor.

    }

    @Bean
    public JdbcTemplate jdbctemplate() throws SQLException {
        return new JdbcTemplate(DataSource()); // databaseye baglanıyoruz. database ıslemlerınde @bean ise yarıyor.
    }



    String usertablesql = "CREATE TABLE User (id BIGINT AUTO_INCREMENT PRIMARY KEY,ad varchar(50),soyad varchar(50),sifre varchar(50),iban varchar(26),tckimlikno varchar(11),dogumtarihi DATE,bakiye DECIMAL(50,2) DEFAULT 0.00);";

    String transactiontablesql = "CREATE TABLE transaction (id BIGINT AUTO_INCREMENT PRIMARY KEY,gondereniban VARCHAR(50),gonderileniban VARCHAR(50),islemtutari DECIMAL(50,2),transfertarihi DATETIME);";

}
