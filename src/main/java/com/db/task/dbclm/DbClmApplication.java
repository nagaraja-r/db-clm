package com.db.task.dbclm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DbClmApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbClmApplication.class, args);
	}

}
