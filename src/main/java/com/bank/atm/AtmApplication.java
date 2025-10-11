package com.bank.atm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtmApplication {

	public static void main(String[] args) {

        SpringApplication.run(AtmApplication.class, args);

	}


}

// tum mysql kodu
// ALTER USER 'root'@'localhost' IDENTIFIED BY 'YeniGucluParola123!';  FLUSH PRIVILEGES;CREATE DATABASE ATM; USE ATM; CREATE TABLE admin (id BIGINT PRIMARY KEY AUTO_INCREMENT, adminname VARCHAR(100) NOT NULL, adminpassword VARCHAR(100) NOT NULL); INSERT INTO admin (adminname, adminpassword) VALUES ('root','root'); CREATE TABLE user (id BIGINT PRIMARY KEY AUTO_INCREMENT, ad VARCHAR(100) NOT NULL, soyad VARCHAR(100) NOT NULL, tckimlikno VARCHAR(11) UNIQUE NOT NULL, password VARCHAR(255) NOT NULL, dogumtarihi DATE NOT NULL, iban VARCHAR(34) UNIQUE NOT NULL, balance DECIMAL(40,2) DEFAULT 0.00);

//Koda Eklenecekler
//
//Sql injection için önlem alınacak
//spam koruması yapılıcak
//log dosyası yapılıcak
//ip spam koruması yapılıcak
//modem ipsinden de spam koruması yapılıcak
//değişkenler ve modellerin ismi daha modern olucak.

//CREATE TABLE user (
//    id BIGINT PRIMARY KEY AUTO_INCREMENT,
//    ad VARCHAR(100) NOT NULL,
//    soyad VARCHAR(100) NOT NULL,
//    tckimlikno VARCHAR(11) UNIQUE NOT NULL,
//    password VARCHAR(255) NOT NULL,
//    dogumtarihi DATE NOT NULL,
//    iban VARCHAR(34) UNIQUE NOT NULL,
//    balance DECIMAL(40,2) DEFAULT 0.00
//);

// ayni tablo CREATE TABLE user (id BIGINT PRIMARY KEY AUTO_INCREMENT, ad VARCHAR(100) NOT NULL, soyad VARCHAR(100) NOT NULL, tckimlikno VARCHAR(11) UNIQUE NOT NULL, password VARCHAR(255) NOT NULL, dogumtarihi DATE NOT NULL, iban VARCHAR(34) UNIQUE NOT NULL, balance DECIMAL(40,2) DEFAULT 0.00);

//localhost:8080/api/user/createuser
//
//	CREATE TABLE admin (
//		id BIGINT PRIMARY KEY AUTO_INCREMENT,
//		adminname VARCHAR(100) NOT NULL,
//	adminpassword VARCHAR(100) NOT NULL)
//CREATE TABLE admin (id BIGINT PRIMARY KEY AUTO_INCREMENT, adminname VARCHAR(100) NOT NULL, adminpassword VARCHAR(100) NOT NULL); INSERT INTO admin (adminname, adminpassword) VALUES ('root','root');
//insert into admin (adminname , adminpassword) VALUES ("root","root");


// tc ve sifre ile dogrulama eklenecek
//para yatırma eklenecek admın transfer normal transfer eklenecek

// tc ve sifre ile dogrulama eklenecek
//para yatırma eklenecek admın transfer normal transfer eklenecek
//ms ayarlanıcak
// mysql portu duzeltilicek

