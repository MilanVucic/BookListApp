
package com.vucic.booklist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vucic.booklist.repository.ApiHelper;
import com.vucic.booklist.repository.callbacks.GetBooksCallback;
import com.vucic.booklist.repository.google_models.SearchResponse;

public class MainActivity extends AppCompatActivity implements GetBooksCallback {

    private ApiHelper apiHelper;
    private RecyclerView booksRecyclerView;
    private ProgressBar loadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        booksRecyclerView = findViewById(R.id.booksRecyclerView);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        EditText searchEditText = findViewById(R.id.searchEditText);
        Button searchButton = findViewById(R.id.searchButton);

        setupRecyclerView();

        apiHelper = new ApiHelper();
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search(searchEditText.getText().toString());
            }
        });
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        booksRecyclerView.setLayoutManager(layoutManager);
        booksRecyclerView.addItemDecoration(new DividerItemDecoration(
                this, layoutManager.getOrientation()));
    }

    private void search(String searchTerm) {
        loadingProgressBar.setVisibility(View.VISIBLE);
        apiHelper.searchBooks(searchTerm, this);
    }

    @Override
    public void onSuccess(SearchResponse data) {
        loadingProgressBar.setVisibility(View.GONE);
        Toast.makeText(this, "" + data.getTotalItems(), Toast.LENGTH_SHORT).show();
        booksRecyclerView.setAdapter(new BooksAdapter(data.getBooks(), this));
    }

    @Override
    public void onFailure(String message) {
        loadingProgressBar.setVisibility(View.GONE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}