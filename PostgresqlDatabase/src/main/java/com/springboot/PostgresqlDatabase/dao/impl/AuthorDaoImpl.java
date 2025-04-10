package com.springboot.PostgresqlDatabase.dao.impl;

import com.springboot.PostgresqlDatabase.dao.AuthorDao;
import com.springboot.PostgresqlDatabase.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;

//@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update(
                "INSERT INTO authors (id, name, age) VALUES (?,?,?)",
                author.getId(),
                author.getName(),
                author.getAge()
        );
    }
}
