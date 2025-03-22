package com.prospera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ProsperaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProsperaApplication.class, args);
	}



}
