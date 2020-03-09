package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World....!");

        Person person = new Person("anil", new ArrayList<>(Collections.singleton(new Address("Bangalore", "India"))), new Date());
        System.out.println(person.getName());
        System.out.println(person.getAddress().get(0).getCity());
        System.out.println(person.getAddress().get(0).getCountry());
        System.out.println(person.getDate());

        person.getAddress().add(new Address("tumkur", "india"));
        person.getDate().setTime(person.getDate().getTime() + 10000);
        System.out.println("after modification");
        System.out.println(person.getAddress());
        System.out.println(person.getDate());

    }
}
