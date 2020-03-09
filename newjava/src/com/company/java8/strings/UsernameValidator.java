package com.company.java8.strings;

public class UsernameValidator {
    private static final String regularExpression = "\\b[a-zA-Z][a-zA-Z0-9_]{7,30}\\b";
    public static void main(String[] args) {
        String userName="Samantha";

        if (userName.matches(regularExpression)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
