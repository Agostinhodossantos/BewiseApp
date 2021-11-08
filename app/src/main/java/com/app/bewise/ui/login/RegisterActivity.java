package com.app.bewise.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.bewise.R;

public class RegisterActivity extends AppCompatActivity {

    Toolbar toolbar;
    private TextView tv_create_by_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUI();
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tv_create_by_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EmailCreateAcountActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initUI() {
        toolbar = findViewById(R.id.toolbar);
        tv_create_by_email = findViewById(R.id.tv_create_by_email);
    }
}