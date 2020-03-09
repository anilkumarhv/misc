package com.company.java8.interfaces;

/*
 * https://dzone.com/articles/j%CE%BBv%CE%BB-8-a-comprehensive-look
 *
 */
@FunctionalInterface
public interface FunctionalInterfaceExample {
    default void test() {
        System.out.println("default method");
    }

    static void test1() {
        System.out.println("static method");
    }

    void abstractMethod();
}
