package com.app.bewise.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.bewise.R;
import com.app.bewise.provider.FirestoreMethods;
import com.app.bewise.ui.main.UserProfileActivity;
import com.app.bewise.utils.Check;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tv_register;
    private TextInputEditText ed_email, ed_password;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    String email, password;
    FirestoreMethods firestoreMethods = new FirestoreMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();

        mAuth = FirebaseAuth.getInstance();

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkFields();
            }
        });
    }

    private void checkFields() {
        email = ed_email.getText().toString().trim();
        password = ed_password.getText().toString().trim();

        if (Check.isEmpty(email)) {
            ed_email.requestFocus();
            ed_email.setError("Este campo deve ser preenchido!");
        } else if (!Check.isValidEmail(email)) {
            ed_email.requestFocus();
            ed_email.setError("Email invalido!");
        } else if (Check.isEmpty(password)) {
            ed_password.requestFocus();
            ed_password.setError("Este campo deve ser preenchido!");
        } else {
            authUser(email, password);
        }
    }

    private void authUser(String email, String password) {
        progressControl(progressBar, tv_register);

    }

    private void progressControl(View show, View hidden) {
        hidden.setVisibility(View.GONE);
        show.setVisibility(View.VISIBLE);
    }

    private void initUI() {
        progressBar = findViewById(R.id.progressBar);
        tv_register = findViewById(R.id.tv_register);
        toolbar = findViewById(R.id.toolbar);
        ed_email = findViewById(R.id.ed_email);
        ed_password = findViewById(R.id.ed_password);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}