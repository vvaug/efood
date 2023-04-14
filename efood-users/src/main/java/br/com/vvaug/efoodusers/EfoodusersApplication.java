package br.com.vvaug.efoodusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class EfoodusersApplication {

	public static void main(String[] args) {
		SpringApplication.run(EfoodusersApplication.class, args);
	}

}
