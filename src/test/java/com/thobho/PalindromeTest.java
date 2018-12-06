package com.thobho;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import sun.util.resources.ParallelListResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PalindromeTest {

    @DisplayName("should be palindrome")
    @ValueSource(strings = {"anna", "radar", "aa aa", "pętaka pętaj a tępaka tęp"})
    public void isPalindrome() {

    }

    @Test
    public void palindromMustNotBeNullTest() {
        try {
            Palindrome.isPalindrome(null);
        } catch (PalindromeMustNotBeNull exception) {
            assertEquals(exception.getMessage(), "Nie może być null, głupcze!");
        }
    }

    @Test
    public void palindromMustNotBeNullTest2() {
        PalindromeMustNotBeNull thrownException = assertThrows(PalindromeMustNotBeNull.class, () -> {
            Palindrome.isPalindrome(null);
        });
        assertEquals(thrownException.getMessage(), "Nie może być null, głupcze!");
    }
}
