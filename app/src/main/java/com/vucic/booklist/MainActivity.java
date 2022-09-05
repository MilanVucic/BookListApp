
package com.vucic.booklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.vucic.booklist.models.Book;
import com.vucic.booklist.repository.BooksRepositoryFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView booksRecyclerView = findViewById(R.id.booksRecyclerView);

        List<Book> bookList = BooksRepositoryFactory.getBooksRepository().getBooks();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        booksRecyclerView.setLayoutManager(layoutManager);
        booksRecyclerView.setAdapter(new BooksAdapter(bookList, this));
        booksRecyclerView.addItemDecoration(new DividerItemDecoration(
                this, layoutManager.getOrientation()));
    }
}