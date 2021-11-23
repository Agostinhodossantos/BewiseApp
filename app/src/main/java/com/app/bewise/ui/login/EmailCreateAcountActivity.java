package com.app.bewise.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.bewise.R;
import com.app.bewise.model.UserBuilder;
import com.app.bewise.utils.Check;
import com.google.android.material.textfield.TextInputEditText;

public class EmailCreateAcountActivity extends AppCompatActivity {

    private TextInputEditText ed_email, ed_password;
    private TextView tv_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_create_acount);
        initUI();

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkFields();
            }
        });
    }

    private void checkFields() {
        String email = ed_email.getText().toString();
        String password = ed_password.getText().toString();

        if (Check.isEmpty(email)) {
            ed_email.requestFocus();
            ed_email.setError("Este campo deve ser preenchido!");
        } else if (Check.isEmpty(password)) {
            ed_password.requestFocus();
            ed_password.setError("Este campo deve ser preenchido!");
        } else {
            authUser(email, password);
        }
    }

    private void authUser(String email, String password) {

    }

    private void initUI() {
        ed_email = findViewById(R.id.ed_email);
        ed_password = findViewById(R.id.ed_password);
        tv_register = findViewById(R.id.tv_register);
    }
}