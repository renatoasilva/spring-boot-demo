package com.example.demo;

import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//		dataSource.setDriverClassName("org.postgresql.Driver");
//		dataSource.setUrl("jdbc:postgresql://localhost:5432/my_table");
//		dataSource.setUsername("activityman");
//		dataSource.setPassword("activitymanpasses");
//		dataSource.setUsername("postgres");
//		dataSource.setPassword("mysecretpassword");
////		dataSource.setUrl(
////			"jdbc:postgres://localhost:5432/my_table?createDatabaseIfNotExist=true");
//
//		return dataSource;
//	}

}
