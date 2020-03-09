package com.company.java8.streamss;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8Sort {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Milan",
                "london",
                "San Francisco",
                "Tokyo",
                "New Delhi");

        System.out.println(cities);
        cities.sort(Comparator.naturalOrder());
        System.out.println(cities);
        cities.sort(String::compareToIgnoreCase);
        System.out.println(cities);
    }
}
