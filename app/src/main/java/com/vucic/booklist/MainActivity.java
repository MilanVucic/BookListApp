
package com.vucic.booklist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vucic.booklist.models.Book;
import com.vucic.booklist.repository.ApiHelper;
import com.vucic.booklist.repository.BooksRepositoryFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ApiHelper apiHelper;
    private TextView numberOfResultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView booksRecyclerView = findViewById(R.id.booksRecyclerView);
        EditText searchEditText = findViewById(R.id.searchEditText);
        Button searchButton = findViewById(R.id.searchButton);
        numberOfResultsTextView = findViewById(R.id.numberOfResultsTextView);

//        List<Book> bookList = BooksRepositoryFactory.getBooksRepository().getBooks();
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        booksRecyclerView.setLayoutManager(layoutManager);
//        booksRecyclerView.setAdapter(new BooksAdapter(bookList, this));
//        booksRecyclerView.addItemDecoration(new DividerItemDecoration(
//                this, layoutManager.getOrientation()));
        apiHelper = new ApiHelper();
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search(searchEditText.getText().toString());
            }
        });
    }

    private void search(String searchTerm) {
        apiHelper.searchBooks(searchTerm);
    }
}