package com.app.bewise.utils;

public class StrFormat {
    public static String toUpperFirst(String str) {
        if (str.length() > 2) {
           return str.substring(0, 1).toUpperCase() + str.substring(1);
        } else {
            return str;
        }
    }
}
