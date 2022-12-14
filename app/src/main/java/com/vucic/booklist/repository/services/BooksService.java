package com.vucic.booklist.repository.services;

import com.vucic.booklist.repository.google_models.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BooksService {
    @GET("books/v1/volumes")
    Call<SearchResponse> searchBooks(@Query("q") String searchTerm);

    @GET("books/v1/volumes/{book_id}")
    Call<SearchResponse> getBookDetails(@Path("book_id") String bookId);
}
