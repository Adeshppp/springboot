package com.springboot.PostgresqlDatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class PostgresqlDatabaseApplication implements CommandLineRunner {


	private final DataSource dataSource;

	public PostgresqlDatabaseApplication(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public static void main(String[] args) {
		SpringApplication.run(PostgresqlDatabaseApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
//		restTemplate.execute("select 1");
//	}

	@Override
	public void run(String... args) throws Exception {
		JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		Integer result = restTemplate.queryForObject("SELECT 1", Integer.class);
		System.out.println("DB Test Query Result: " + result);
		Thread.sleep(10000); // Keeps app alive for 10 seconds
	}


}





