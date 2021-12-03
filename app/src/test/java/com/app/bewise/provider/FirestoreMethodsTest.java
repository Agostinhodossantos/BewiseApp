package com.app.bewise.provider;

import junit.framework.TestCase;

public class FirestoreMethodsTest extends TestCase {

    public void testCreateUser() {
    }

    public void testGetUser() {
    }

    public void testCreateBook() {
    }

    public void testGetBook() {
    }

    public void testGetBookByCategory() {
    }

    public void testGetAllBooks() {
        FirestoreMethods methods = new FirestoreMethods();
        methods.getAllBooks(new FirestoreMethods.ResponseListener() {
            @Override
            public void onSuccess(Object response) {

            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}