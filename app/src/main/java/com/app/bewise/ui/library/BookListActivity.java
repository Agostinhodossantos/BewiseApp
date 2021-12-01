package com.app.bewise.ui.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.app.bewise.R;
import com.app.bewise.adapters.VerticalBooksListAdapter;
import com.app.bewise.model.Book;
import com.app.bewise.provider.FirestoreMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rv_books;
    FirestoreMethods methods = new FirestoreMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        initUI();

        toolbar.setTitle("Matematica");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getBooksByCategory();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.library_menu, menu);
        return true;
    }

    private void getBooksByCategory() {

        methods.getAllBooks(new FirestoreMethods.ResponseListener() {
            @Override
            public void onSuccess(Object response) {
                VerticalBooksListAdapter adapter = new VerticalBooksListAdapter(
                        BookListActivity.this, (List<Book>) response);
                StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
                        1, LinearLayoutManager.VERTICAL);
                rv_books.setLayoutManager(layoutManager);
                rv_books.setAdapter(adapter);
            }

            @Override
            public void onFailure(String message) {

            }
        });

    }

    private void initUI() {
        toolbar = findViewById(R.id.toolbar);
        rv_books = findViewById(R.id.rv_books_list);
    }
}