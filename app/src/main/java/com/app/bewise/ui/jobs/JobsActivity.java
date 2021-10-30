package com.app.bewise.ui.jobs;

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

public class JobsActivity extends AppCompatActivity {

    private RecyclerView rv_jobs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        initUI();

        getBooks();
    }

    private void initUI() {
        rv_jobs = findViewById(R.id.rv_jobs);
    }

    private void getBooks() {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("", "", "", "", "");
            bookList.add(book);
        }

        BooksListAdapter adapter = new BooksListAdapter(this, bookList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
        rv_jobs.setLayoutManager(layoutManager);
        rv_jobs.setAdapter(adapter);
    }
}