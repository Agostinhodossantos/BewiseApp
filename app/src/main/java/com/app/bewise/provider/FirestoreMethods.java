package com.app.bewise.provider;

import androidx.annotation.NonNull;

import com.app.bewise.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirestoreMethods {

    public interface ResponseListener{
        void onSuccess(Object response);
        void onFailure(String message);
    }

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public void createUser(User user, ResponseListener responseListener) {
        db.collection("users")
                .document(user.id)
                .set(user)
                .addOnSuccessListener(unused -> {
                    responseListener.onSuccess("User created ");

        }).addOnFailureListener(e -> {
            responseListener.onFailure(e.getMessage());
        });
    }

    public void getUser(String id, ResponseListener responseListener) {
        db.collection("users").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = documentSnapshot.toObject(User.class);
                responseListener.onSuccess(user);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                responseListener.onFailure(e.getMessage());
            }
        });
    }
    
}
