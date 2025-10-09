package com.bank.atm;
import com.bank.atm.repository.userrepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtmApplication {

	public static void main(String[] args) {



	}


}

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
//    balance FLOAT DEFAULT 0
//);

//localhost:8080/api/user/createuser
//
//	CREATE TABLE admin (
//		id BIGINT PRIMARY KEY AUTO_INCREMENT,
//		adminname VARCHAR(100) NOT NULL,
//	adminpassword VARCHAR(100) NOT NULL)

//insert into admin (adminname , adminpassword) VALUES ("root","root");
