package com.company.java8.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveDuplicateWords {
    public static void main(String[] args) {
        String input = "The the string String string stringing.";
        final String PATTERN = "\\b(\\w+)(\\s+\\1\\b)+";

        Pattern p = Pattern.compile(PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        while (m.find()) {
            input = input.replaceAll(m.group(), m.group(1));
        }
        System.out.println(input);
    }
}
