package com.vucic.booklist.repository;

import com.vucic.booklist.models.Book;

import java.util.List;

public interface BooksRepository {
    List<Book> getBooks();
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByKeyword(String keyword);
}
