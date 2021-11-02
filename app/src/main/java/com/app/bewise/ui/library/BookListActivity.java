package com.app.bewise.ui.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;

import com.app.bewise.R;
import com.app.bewise.adapters.VerticalBooksListAdapter;
import com.app.bewise.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rv_books;

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
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Book book = new Book("", "", "", "", "");
            bookList.add(book);
        }

        VerticalBooksListAdapter adapter = new VerticalBooksListAdapter(this, bookList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        rv_books.setLayoutManager(layoutManager);
        rv_books.setAdapter(adapter);
    }

    private void initUI() {
        toolbar = findViewById(R.id.toolbar);
        rv_books = findViewById(R.id.rv_books_list);
    }
}