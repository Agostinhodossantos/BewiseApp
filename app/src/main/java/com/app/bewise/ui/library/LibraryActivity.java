package com.app.bewise.ui.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.bewise.R;
import com.app.bewise.adapters.BooksCategoryAdapter;
import com.app.bewise.adapters.BooksListAdapter;
import com.app.bewise.adapters.VerticalBooksListAdapter;
import com.app.bewise.model.Book;
import com.app.bewise.model.BookCategory;
import com.app.bewise.provider.FirestoreMethods;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    private RecyclerView rv_books, rv_books_category, rv_my_books;
    private FirestoreMethods firestoreMethods = new FirestoreMethods();
    private ShimmerFrameLayout shimmer_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        initUI();
        getBooks();
        getCategory();
        getMyBook();
    }

    private void getBooks() {

        firestoreMethods.getAllBooks(new FirestoreMethods.ResponseListener() {
            @Override
            public void onSuccess(Object response) {
                // hide shimer
                shimmer_layout.stopShimmer();
                shimmer_layout.setVisibility(View.GONE);

                BooksListAdapter adapter = new BooksListAdapter(LibraryActivity.this, (List<Book>) response);
                StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
                rv_books.setLayoutManager(layoutManager);
                rv_books.setAdapter(adapter);
            }

            @Override
            public void onFailure(String message) {

            }
        });

    }

    private void getCategory() {
        List<BookCategory> categoryList = new ArrayList<>();


        categoryList.add(new BookCategory("1", "Matematica", 1));
        categoryList.add(new BookCategory("1", "Quimica", 1));
        categoryList.add(new BookCategory("1", "Geografia", 1));
        categoryList.add(new BookCategory("1", "Fisica", 1));
        categoryList.add(new BookCategory("1", "Ingles", 1));
        categoryList.add(new BookCategory("1", "DGD", 1));
        categoryList.add(new BookCategory("1", "Filosofia", 1));


        Toast.makeText(LibraryActivity.this, ""+categoryList.size(), Toast.LENGTH_SHORT).show();
        BooksCategoryAdapter adapter = new BooksCategoryAdapter(this, categoryList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
        rv_books_category.setLayoutManager(layoutManager);
        rv_books_category.setAdapter(adapter);
    }

    private void getMyBook() {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Book book = new Book("", "","","", "", "", "");
            bookList.add(book);
        }

        VerticalBooksListAdapter adapter = new VerticalBooksListAdapter(this, bookList);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        rv_my_books.setLayoutManager(layoutManager);
        rv_my_books.setAdapter(adapter);
    }

    private void initUI() {
        rv_books = findViewById(R.id.rv_books);
        rv_books_category = findViewById(R.id.rv_books_category);
        rv_my_books = findViewById(R.id.rv_books_vertical);
        shimmer_layout = findViewById(R.id.shimmer_layout);
    }


}