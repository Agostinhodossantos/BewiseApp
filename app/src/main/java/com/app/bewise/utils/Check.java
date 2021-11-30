package com.app.bewise.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_PASSWORD_ADDRESS_REGEX =
            Pattern.compile("^(?=\\S+$).{6,}$", Pattern.CASE_INSENSITIVE);

    public static boolean isEmpty(String value) {
        if (value.trim() == null || value.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public static boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD_ADDRESS_REGEX.matcher(password);
        return matcher.find();
    }
}
