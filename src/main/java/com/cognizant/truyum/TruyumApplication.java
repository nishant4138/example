package com.cognizant.truyum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
import org.springframework.cloud.openfeign.EnableFeignClients;

//import com.cognizant.truyum.security.AppUserDetailsService;


@SpringBootApplication
@EnableFeignClients
public class TruyumApplication {
	public static void main(String[] args) {
		SpringApplication.run(TruyumApplication.class, args);
	}
}
