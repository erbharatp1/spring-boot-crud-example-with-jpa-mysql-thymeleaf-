package com.pilog.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Bharat
 *
 */
@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("DemoApplication.main()");
		SpringApplication.run(DemoApplication.class, args);
	}

}
