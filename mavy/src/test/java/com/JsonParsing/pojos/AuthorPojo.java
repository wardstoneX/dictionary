package com.JsonParsing.pojos;

import java.util.List;

public class AuthorPojo {
    private String name;
    private List<BookPojo> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookPojo> getBooks() {
        return books;
    }

    public void setBooks(List<BookPojo> books) {
        this.books = books;
    }
}
