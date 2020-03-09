package com.company.java8.streamss;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsJava8 {
    public static void main(String[] args) {
        List<Profile> profiles = Arrays.asList(
                new Profile("Anil", 26),
                new Profile("Jack", 20),
                new Profile("Lawrence", 40),
                new Profile("Aws", 30)
        );

        System.out.println("Profile list");
        List<Profile> profileList = profiles.stream().filter(p -> p.getAge() > 20).collect(Collectors.toList());
        System.out.println(profileList);

        System.out.println("Get Names age gt > 20");
        List<String> nameList = profiles.stream().filter(p -> p.getAge() > 20).map(Profile::getName).collect(Collectors.toList());
        System.out.println(nameList);

        System.out.println("Get Name start with Anil");
        String name = profiles.stream().filter(p -> "Anil".equalsIgnoreCase(p.getName())).map(Profile::getName).findAny().orElse(null);
        System.out.println(name);

        System.out.println("Get Name start with Custom ");
        String pn = profiles.stream().filter(StreamsJava8::hasValidProfile).map(Profile::getName).findAny().orElse(null);
        System.out.println(pn);

        //profiles.stream().map(Profile::getName).flatMap(p->p.stream)
        List<String> collect =
                profiles.stream()
                        //.map(Profile::getName)      //Stream<Set<String>>
                        .flatMap(x -> Stream.of(x.getName()))
                        .sorted(String::compareToIgnoreCase)   //Stream<String>
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("String 2D array to List<List<String>>");
        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        List<List<String>> temp = Arrays.stream(data).map(Arrays::asList).collect(Collectors.toList());
        temp.forEach(System.out::println);

//        int[][] data1 = new int[][]{{1, 2}, {3, 4}, {5, 6}};
//        List<List<Integer>> tempInt = Arrays.stream(data1).map(Arrays::asList).flatMap(x -> Arrays.stream(x.toArray())).map(c -> Stream.of(((int) c)).collect(Collectors.toList())).collect(Collectors.toList());
//        System.out.println(tempInt);

    }

    public static boolean hasValidProfile(Profile profile) {
        return profile.getAge() > 25 && "anil".equalsIgnoreCase(profile.getName());
    }
}


class Profile {
    private String name;
    private int age;

    public Profile(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
