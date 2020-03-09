package com.company.java8.strings;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StringCharCount {
    public static void main(String[] args) {
        String input = "hello how are you";

        Map<Object, Long> frequentChars = Arrays.stream(input.toLowerCase().split("")).filter(s -> !s.equalsIgnoreCase(" ")).collect(
                Collectors.groupingBy(c -> c, Collectors.counting()));
        frequentChars.forEach((k, v) -> System.out.println(k + ":" + v));

        String str = "Thequickbrownfoxjumpsoverthelazydog";
        int size = 3;
        String INPUT = "The dog says meow. " + "All dogs say meow.";

        String[] tokens = str.split("(?<=\\G.{" + size + "})");
        System.out.println(Arrays.toString(tokens));
        INPUT = INPUT.replaceAll("dog", "cat");
        System.out.println(INPUT);
    }
}
