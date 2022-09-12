package com.vucic.booklist.repository.google_models;

import com.google.gson.annotations.SerializedName;
import com.vucic.booklist.models.Book;

import java.util.ArrayList;
import java.util.List;

public class SearchResponse {
    @SerializedName("kind")
    private String kind;
    @SerializedName("totalItems")
    private int totalItems;
    @SerializedName("items")
    private List<BookModel> books;

    public int getTotalItems() {
        return totalItems;
    }

    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.addAll(books);
        return bookList;
    }
}
