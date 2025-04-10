package com.springboot.PostgresqlDatabase.dao;

import com.springboot.PostgresqlDatabase.domain.Book;

public interface BookDao {
    void create(Book book);
}
