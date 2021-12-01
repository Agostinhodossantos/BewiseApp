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
        FirestoreMethods methods = new FirestoreMethods();
        List<Book> bookList = new ArrayList<>();
        Book book;

        book = new Book(UUID.randomUUID().toString(), "Book title here", "1", "author","https://firebasestorage.googleapis.com/v0/b/fb-api-2fc74.appspot.com/o/app_assets%2Fbook1.jpg?alt=media&token=471128ed-a3b1-4f54-b82a-552ad780b1d5", "https://firebasestorage.googleapis.com/v0/b/fb-api-2fc74.appspot.com/o/app_assets%2FWeapons-of-Math-Destruction-Cathy-ONeil.pdf?alt=media&token=1d5cc79e-3f93-46d7-851a-ff3fffdf5c43");
        bookList.add(book);
        book = new Book(UUID.randomUUID().toString(), "Book title here", "1", "author","https://firebasestorage.googleapis.com/v0/b/fb-api-2fc74.appspot.com/o/app_assets%2Fbook3.jpeg?alt=media&token=eefe9380-4c97-4e6b-a9e9-13d3e4db29de", "https://firebasestorage.googleapis.com/v0/b/fb-api-2fc74.appspot.com/o/app_assets%2FWeapons-of-Math-Destruction-Cathy-ONeil.pdf?alt=media&token=1d5cc79e-3f93-46d7-851a-ff3fffdf5c43");
        bookList.add(book);
        book = new Book(UUID.randomUUID().toString(), "Book title here", "1", "author","https://firebasestorage.googleapis.com/v0/b/fb-api-2fc74.appspot.com/o/app_assets%2Fbooks.jpeg?alt=media&token=ccb7eca2-8849-4792-a361-e7fcaeb2dc21", "https://firebasestorage.googleapis.com/v0/b/fb-api-2fc74.appspot.com/o/app_assets%2FWeapons-of-Math-Destruction-Cathy-ONeil.pdf?alt=media&token=1d5cc79e-3f93-46d7-851a-ff3fffdf5c43");
        bookList.add(book);


        for (int i = 0; i < bookList.size(); i++) {
            methods.createBook(bookList.get(i), new FirestoreMethods.ResponseListener() {
                @Override
                public void onSuccess(Object response) {
                    Toast.makeText(BookListActivity.this, "", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(String message) {
                    Toast.makeText(BookListActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            });

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