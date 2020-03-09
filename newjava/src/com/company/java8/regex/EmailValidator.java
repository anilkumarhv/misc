package com.company.java8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        String emailId = "anilkumarhv04@gmail.co.in";
//        String emailId = "shamik@gmail.co.i";
        System.out.println(isEmailValid(emailId));

    }

    private static final String emailRegex = "^[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static Boolean isEmailValid(String emailId) {
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(emailId);
        return matcher.matches();
        //return emailId.matches(emailRegex);
    }
}
