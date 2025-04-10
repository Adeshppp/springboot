package com.springboot.PostgresqlDatabase.dao;

import com.springboot.PostgresqlDatabase.domain.Author;

public interface AuthorDao {
    void create(Author author);
}
