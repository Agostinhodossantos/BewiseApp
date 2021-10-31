package com.app.bewise.ui.jobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.app.bewise.R;
import com.app.bewise.adapters.BooksListAdapter;
import com.app.bewise.adapters.JobsListAdapter;
import com.app.bewise.adapters.VerticalBooksListAdapter;
import com.app.bewise.model.Book;

import java.util.ArrayList;
import java.util.List;

public class JobsActivity extends AppCompatActivity {

    private RecyclerView rv_jobs, rv_my_jobs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        initUI();

        getJobs();
    }

    private void initUI() {
        rv_jobs = findViewById(R.id.rv_jobs);
        rv_my_jobs = findViewById(R.id.rv_my_jobs);
    }


    private void getMyJobs() {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Book book = new Book("", "", "", "", "");
            bookList.add(book);
        }

        VerticalBooksListAdapter adapter = new VerticalBooksListAdapter(this, bookList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        rv_my_jobs.setLayoutManager(layoutManager);
        rv_my_jobs.setAdapter(adapter);
    }


    private void getJobs() {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("", "", "", "", "");
            bookList.add(book);
        }

        JobsListAdapter adapter = new JobsListAdapter(this, bookList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
        rv_jobs.setLayoutManager(layoutManager);
        rv_jobs.setAdapter(adapter);
    }
}