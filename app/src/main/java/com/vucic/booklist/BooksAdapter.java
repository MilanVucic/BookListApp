package com.vucic.booklist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.vucic.booklist.models.Book;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {
    private List<Book> bookList;
    private Context context;

    public BooksAdapter(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_item_layout, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        bindBook(holder, bookList.get(position), position);
    }

    private void bindBook(BookViewHolder holder, Book book, int position) {
        holder.titleTextView.setText(book.getTitle());
        holder.subtitleTextView.setText(book.getSubtitle());
        List<String> authors = book.getAuthors();
        setAuthors(holder, authors);
        setBackground(holder, position);
        loadImage(book, holder.thumbnailImageView);
    }

    private void setAuthors(BookViewHolder holder, List<String> authors) {
        if (authors != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < authors.size(); i++) {
                stringBuilder.append(authors.get(i));
                if (i != authors.size() - 1) {
                    stringBuilder.append(", ");
                }
            }
            holder.authorTextView.setText(stringBuilder.toString());
        } else {
            holder.authorTextView.setText("Unknown");
        }
    }

    private void setBackground(BookViewHolder holder, int position) {
        if (position % 2 == 0) {
            holder.containerLayout.setBackgroundColor(
                    context.getResources().getColor(R.color.book_background_2));
        } else {
            holder.containerLayout.setBackgroundColor(
                    context.getResources().getColor(R.color.book_background_1));
        }
    }

    private void loadImage(Book book, ImageView imageView) {
        Picasso.get().load(book.getImageUrl()).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                Log.i("SOME_TAG", "Success");
            }

            @Override
            public void onError(Exception e) {
                Log.i("SOME_TAG", "No Success");
                e.printStackTrace();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView subtitleTextView;
        TextView authorTextView;
        ImageView thumbnailImageView;
        ConstraintLayout containerLayout;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            thumbnailImageView = itemView.findViewById(R.id.thumbnailImageView);
            subtitleTextView = itemView.findViewById(R.id.subtitleTextView);
            authorTextView = itemView.findViewById(R.id.authorTextView);
            containerLayout = itemView.findViewById(R.id.containerLayout);
        }
    }
}
