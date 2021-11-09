package com.app.bewise.utils;

public class Check {
    public static boolean isEmpty(String value) {
        if (value.trim() == null || value.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
