package br.com.vvaug.efoodregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EfoodregisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EfoodregisterApplication.class, args);
	}

}
