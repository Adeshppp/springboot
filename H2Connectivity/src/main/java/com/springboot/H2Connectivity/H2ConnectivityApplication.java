package com.springboot.H2Connectivity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class H2ConnectivityApplication implements CommandLineRunner {

	private final DataSource dataSource;

    public H2ConnectivityApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
		SpringApplication.run(H2ConnectivityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}
