package br.com.vvaug.efoodlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EfoodLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(EfoodLoginApplication.class, args);
	}

}
