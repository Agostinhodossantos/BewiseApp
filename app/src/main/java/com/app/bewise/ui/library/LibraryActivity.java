package com.app.bewise.ui.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.app.bewise.R;
import com.app.bewise.adapters.BooksListAdapter;
import com.app.bewise.model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    RecyclerView rv_books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        initUI();
        getBooks();
    }

    private void getBooks() {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("", "", "", "", "");
            bookList.add(book);
        }

        BooksListAdapter adapter = new BooksListAdapter(this, bookList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
        rv_books.setLayoutManager(layoutManager);
        rv_books.setAdapter(adapter);
    }

    private void initUI() {
        rv_books = findViewById(R.id.rv_books);
    }


}