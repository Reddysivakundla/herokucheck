package com.sharethought;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EntityScan("com.sharethought.entity")
@PropertySource(value={"classpath:messages.properties"})
public class MythougthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MythougthApplication.class, args);
	}

}
