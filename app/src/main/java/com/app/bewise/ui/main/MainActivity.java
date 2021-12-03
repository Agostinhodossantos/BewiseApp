package com.app.bewise.ui.main;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.app.bewise.R;
import com.app.bewise.model.Book;
import com.app.bewise.model.Category;
import com.app.bewise.provider.AuthUser;
import com.app.bewise.provider.FirestoreMethods;
import com.app.bewise.ui.login.OnboardingActivity;
import com.app.bewise.utils.Util;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_study, R.id.nav_news)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        navigationView.setItemIconTintList(ColorStateList.valueOf(Color.GRAY));

        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case  R.id.action_img:
                if (AuthUser.isAuth()) {
                    Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, OnboardingActivity.class);
                    startActivity(intent);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void createBookTest() {
        FirestoreMethods methods = new FirestoreMethods();
        Random random = new Random(12);
        Random random1 = new Random(0);

        String[] arr = {
                "https://firebasestorage.googleapis.com/v0/b/fb-api-2fc74.appspot.com/o/app_assets%2Fbook1.jpg?alt=media&token=471128ed-a3b1-4f54-b82a-552ad780b1d5",
                "https://firebasestorage.googleapis.com/v0/b/fb-api-2fc74.appspot.com/o/app_assets%2Fbook3.jpeg?alt=media&token=eefe9380-4c97-4e6b-a9e9-13d3e4db29de",
                "https://firebasestorage.googleapis.com/v0/b/fb-api-2fc74.appspot.com/o/app_assets%2Fbooks.jpeg?alt=media&token=ccb7eca2-8849-4792-a361-e7fcaeb2dc21"
        };
        for (int i = 0; i < Util.getCategory().size(); i++) {
            Book book = new Book(UUID.randomUUID().toString(),
                    "The Truth About Your Future",
                    "NEW YORK TIMES BESTSELLER New York Times bestselling author and legendary investment guru Ric Edelman reveals his forward-thinking guide on how technology and science will reshape the way we save, invest, and plan for the future.Technology and science are evolving at a blistering, almost incomprehensible pace. The Human Genome Project took eleven years and $2.7 billion dollars to complete. ",
                    "Ric Edelman",
                    arr[random1.nextInt(arr.length)],
                    "https://firebasestorage.googleapis.com/v0/b/fb-api-2fc74.appspot.com/o/app_assets%2FWeapons-of-Math-Destruction-Cathy-ONeil.pdf?alt=media&token=1d5cc79e-3f93-46d7-851a-ff3fffdf5c43",
                    new Category(  random.nextInt(12), Util.getCategory().get(i).getIdCategory()));
            methods.createBook(book, new FirestoreMethods.ResponseListener() {
                @Override
                public void onSuccess(Object response) {

                }

                @Override
                public void onFailure(String message) {

                }
            });
        }



    }
}
