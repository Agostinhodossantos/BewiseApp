package com.app.bewise.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.bewise.R;
import com.app.bewise.model.UserBuilder;
import com.app.bewise.provider.UserProvider;
import com.app.bewise.ui.main.MainActivity;
import com.app.bewise.utils.Check;
import com.app.bewise.utils.Util;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONObject;

public class EmailCreateAcountActivity extends AppCompatActivity {

    private TextInputEditText ed_email, ed_password;
    private TextView tv_register;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_create_acount);
        initUI();
        mAuth = FirebaseAuth.getInstance();

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkFields();
            }
        });
    }

    private void checkFields() {
        email = ed_email.getText().toString();
        password = ed_password.getText().toString();

        if (Check.isEmpty(email)) {
            ed_email.requestFocus();
            ed_email.setError("Este campo deve ser preenchido!");
        } else if (Check.isEmpty(password)) {
            ed_password.requestFocus();
            ed_password.setError("Este campo deve ser preenchido!");
        } else {
            // set user data in user model
            UserBuilder userBuilder = new UserBuilder();
            userBuilder.setEmail(email);
            userBuilder.setId("12244");

            new UserProvider(this).setUser(userBuilder, new UserProvider
                    .VolleyResponseListener() {
                @Override
                public void onError(String message) {
                    Toast.makeText(EmailCreateAcountActivity.this, message, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onResponse(Object response) {
                    Toast.makeText(EmailCreateAcountActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                }
            });
            //authUser(email, password);
        }
    }

    private void authUser(String email, String password) {
        progressControl(progressBar, tv_register);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Log.d("user", user.toString());
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            updateUI(null);
                        }
                    }
                });
    }

    private void sendEmailVerification() {
        // Send verification email
        // [START send_email_verification]
//        final FirebaseUser user = mAuth.getCurrentUser();
//        user.sendEmailVerification()
//                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        // Email sents
//                    }
//                });
        // [END send_email_verification]
    }

    private void updateUI(FirebaseUser user) {
        Log.d("user", user.toString());
        Toast.makeText(EmailCreateAcountActivity.this, ""+user, Toast.LENGTH_SHORT).show();
        if (user != null ) {
            progressControl(tv_register, progressBar);
        } else {
            sendEmailVerification();
            // set user data in user model
            UserBuilder userBuilder = new UserBuilder();
            userBuilder.setEmail(email);
            userBuilder.setId("12244");

            new UserProvider(this).setUser(userBuilder, new UserProvider.VolleyResponseListener() {
                @Override
                public void onError(String message) {

                }

                @Override
                public void onResponse(Object response) {

                }
            });
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void progressControl(View show, View hidden) {
        hidden.setVisibility(View.GONE);
        show.setVisibility(View.VISIBLE);
    }

    private void initUI() {
        progressBar = findViewById(R.id.progressBar);
        ed_email = findViewById(R.id.ed_email);
        ed_password = findViewById(R.id.ed_password);
        tv_register = findViewById(R.id.tv_register);
    }

}