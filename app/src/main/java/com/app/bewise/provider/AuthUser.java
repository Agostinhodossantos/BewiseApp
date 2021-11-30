package com.app.bewise.provider;

import com.google.firebase.auth.FirebaseAuth;

public class AuthUser {
    public static FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public static boolean isAuth() {
        if (mAuth.getCurrentUser() == null) {
            return false;
        } else {
            return true;
        }
    }
}
