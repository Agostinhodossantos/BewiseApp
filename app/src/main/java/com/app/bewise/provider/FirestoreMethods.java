package com.app.bewise.provider;

import androidx.annotation.NonNull;

import com.app.bewise.model.Book;
import com.app.bewise.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FirestoreMethods {

    public interface ResponseListener{
        void onSuccess(Object response);
        void onFailure(String message);
    }

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    // USER CRUD
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
        db.collection("users")
                .document(id)
                .get()
                .addOnSuccessListener(documentSnapshot -> {
            User user = documentSnapshot.toObject(User.class);
            responseListener.onSuccess(user);
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                responseListener.onFailure(e.getMessage());
            }
        });
    }

    // BOOK CRUD
    public void createBook(Book book, ResponseListener listener) {
        db.collection("books")
                .document(book.getId())
                .set(book)
                .addOnSuccessListener(unused -> {
                    listener.onSuccess(book);
                })
                .addOnFailureListener(e -> {
                    listener.onFailure(e.getMessage());
                });
    }

    public void getBook(String id, ResponseListener listener) {
        db.collection("books")
                .document(id)
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    Book book = documentSnapshot.toObject(Book.class);
                    listener.onSuccess(book);
                })
                .addOnFailureListener(e -> {
                    listener.onFailure(e.getMessage());
                });
    }

    public void getAllBooks(ResponseListener listener) {
        db.collection("books")
                .get()
                .addOnCompleteListener(task -> {
                   if (task.isSuccessful()) {
                       List<Book> bookList = new ArrayList<>();
                       for (DocumentSnapshot document : task.getResult()) {
                           Book book = document.toObject(Book.class);
                           bookList.add(book);
                       }
                       listener.onSuccess(bookList);

                   } else {
                       listener.onFailure("An error has occurred");
                   }
                });
    }



    
}
