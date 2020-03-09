package com.company.java8.strings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TagContentExtractor {
    public static void main(String[] args) {
        String line = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";

        boolean matchFound = false;
        Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
        Matcher m = r.matcher(line);

        while (m.find()) {
//            System.out.println(m.group(0));
//            System.out.println(m.group(1));
            System.out.println(m.group(2));
            matchFound = true;
        }
        if (!matchFound) {
            System.out.println("None");
        }

//        List<String> list = IntStream.range(0, line.length() - 3 + 1).mapToObj(index -> line.substring(index, 3)).collect(Collectors.toList());
//        System.out.println(list);


        Set<Integer> integers= new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(9);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(1);
        integers.add(4);
        integers.add(1);
        integers.add(5);
        integers.add(7);
        List<Integer> list1=new ArrayList<>(integers);
        list1.stream().sorted().forEach(System.out::println);



    }
}
