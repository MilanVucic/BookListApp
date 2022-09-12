package com.vucic.booklist.repository;

import com.vucic.booklist.repository.callbacks.GetBooksCallback;
import com.vucic.booklist.repository.google_models.SearchResponse;
import com.vucic.booklist.repository.services.BooksService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    public static final String TAG = "API_HELPER";
    private Retrofit retrofit;

    public ApiHelper() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void searchBooks(String searchTerm, GetBooksCallback callback) {
        BooksService booksService = retrofit.create(BooksService.class);
        Call<SearchResponse> call = booksService.searchBooks(searchTerm);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.isSuccessful()) {
                    SearchResponse body = response.body();
                    callback.onSuccess(body);
                } else {
                    callback.onFailure("Response not successful:" + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                callback.onFailure("Check connection.");
                t.printStackTrace();
            }
        });
    }
}
