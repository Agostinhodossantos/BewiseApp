package com.app.bewise.utils;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

import org.junit.Test;

public class CheckUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void email_validation_isCorrect(){
        assertEquals(true, Check.isValidEmail("agostinhodev@gmail.com"));
        assertEquals(false, Check.isValidEmail("agostinho"));
    }

    @Test
    public void password_validation_isCorrent() {
        assertEquals(true, Check.isValidPassword("Dossantos00"));
        assertEquals(false, Check.isValidPassword("1234"));
    }

    @Test
    public void emptystr_validation_isCorrent() {
        assertEquals(true, Check.isEmpty(""));
        assertEquals(false, Check.isEmpty("value"));
    }

}