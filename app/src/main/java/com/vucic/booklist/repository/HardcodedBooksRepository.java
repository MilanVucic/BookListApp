package com.vucic.booklist.repository;

import com.vucic.booklist.models.Book;
import com.vucic.booklist.models.HardcodedBook;

import java.util.ArrayList;
import java.util.List;

public class HardcodedBooksRepository implements BooksRepository {
    private List<Book> list = new ArrayList<>();
    {
        list.add(new HardcodedBook("Linux", "Linus Torvalds"));
        list.add(new HardcodedBook("Short history of nearly everything", "Bill Bryson"));
        list.add(new HardcodedBook("Going postal", "Terry Pratchett"));
        list.add(new HardcodedBook("postal", "Terry Pratchett"));
        list.add(new HardcodedBook("Going", "Terry Pratchett"));
        list.add(new HardcodedBook("Something", "Terry Pratchett"));
        list.add(new HardcodedBook("Something 2", "Terry Pratchett"));
        list.add(new HardcodedBook("New book", "Terry Pratchett"));
        list.add(new HardcodedBook("Some other book", "Terry Pratchett"));
        list.add(new HardcodedBook("More books", "Terry Pratchett"));
        list.add(new HardcodedBook("Book 1", "Terry Pratchett"));
        list.add(new HardcodedBook("Book 2", "Terry Pratchett"));
        list.add(new HardcodedBook("Good book", "Terry Pratchett"));
        list.add(new HardcodedBook("New Book", "Terry Pratchett"));
    }

    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> getBooksByKeyword(String keyword) {
        return null;
    }
}
