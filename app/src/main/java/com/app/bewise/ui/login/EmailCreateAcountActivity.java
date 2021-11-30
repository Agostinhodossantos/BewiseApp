package com.app.bewise.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.bewise.R;
import com.app.bewise.model.User;
import com.app.bewise.provider.FirestoreMethods;
import com.app.bewise.provider.UserProvider;
import com.app.bewise.ui.main.MainActivity;
import com.app.bewise.utils.Check;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EmailCreateAcountActivity extends AppCompatActivity {

    private TextInputEditText ed_email, ed_password;
    private TextView tv_register;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    String email, password;
    FirestoreMethods firestoreMethods = new FirestoreMethods();

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
        } else if(!Check.isValidEmail(email)){
            ed_email.requestFocus();
            ed_email.setError("Email invalido!");
        } else if (Check.isEmpty(password)) {
            ed_password.requestFocus();
            ed_password.setError("Este campo deve ser preenchido!");
        } else if (Check.isValidPassword(password)) {
            ed_password.requestFocus();
            ed_password.setError("Password invalido deve ter 6 letras no minimo!");
        } else {
            authUser(email, password);
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
        Toast.makeText(EmailCreateAcountActivity.this, ""+user, Toast.LENGTH_SHORT).show();
        if (user == null ) {
            progressControl(tv_register, progressBar);
        } else {
          User userModel = new User();
          userModel.id = user.getUid();
          userModel.email = email;

          firestoreMethods.createUser(userModel, new FirestoreMethods.ResponseListener() {
              @Override
              public void onSuccess(Object response) {
                  Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                  startActivity(intent);
                  finish();
              }

              @Override
              public void onFailure(String message) {
                  Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
              }
          });

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