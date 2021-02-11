package com.sharethought;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.sharethought.entity")
public class MythougthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MythougthApplication.class, args);
	}

}
