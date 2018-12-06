package com.thobho;

import java.util.Stack;

public class Palindrome {

    static boolean isPalindrome(String word){
        if(word == null){
            throw new PalindromeMustNotBeNull("Nie może być null, głupcze!");
        }
        String wordWithoutSpaces = word.replace(" ", "");

        String reversedString = new StringBuilder(wordWithoutSpaces).reverse().toString();

        return wordWithoutSpaces.equals(reversedString);
    }

    static boolean isPalindromeStack(String word){

        if(word == null){
            return false;
        }
        String wordWithoutSpaces = word.replace(" ", "");

        Stack<Character> charactersStack = new Stack<>();

        for (int i = 0; i < wordWithoutSpaces.length(); i++) {
            char charAt = wordWithoutSpaces.charAt(i);
            charactersStack.push(charAt);
        }

        StringBuilder reversedWord = new StringBuilder();
        while (!charactersStack.isEmpty()){
            reversedWord.append(charactersStack.pop());
        }

        return wordWithoutSpaces.equals(reversedWord.toString());
    }

    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();

        System.out.println(Palindrome.isPalindrome("  an na"));
    }

}
