package com.app.bewise.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.app.bewise.R;
import com.app.bewise.model.User;
import com.app.bewise.provider.FirestoreMethods;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProfileActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirestoreMethods firestoreMethods = new FirestoreMethods();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        firestoreMethods.getUser(user.getUid(), new FirestoreMethods.ResponseListener() {
            @Override
            public void onSuccess(Object response) {
                User user1 = (User) response;

                Toast.makeText(getApplicationContext(), ""+user1.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(String message) {

            }
        });

    }
}