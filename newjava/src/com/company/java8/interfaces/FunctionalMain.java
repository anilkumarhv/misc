package com.company.java8.interfaces;

public class FunctionalMain {
    public static void main(String[] args) {
        FunctionalInterfaceExample fi = () -> System.out.println("Functional Interface Example");
        fi.abstractMethod();
        fi.test();
        FunctionalInterfaceExample.test1();
    }
}
