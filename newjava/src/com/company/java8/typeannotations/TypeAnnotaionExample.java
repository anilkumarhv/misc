package com.company.java8.typeannotations;

import com.sun.istack.internal.NotNull;

public class TypeAnnotaionExample {
    public static void main(String[] args) {
        @Encrypted String abx = "sdfsgd";
        @NotNull String xyz = null;

        System.out.println(xyz);
        System.out.println(abx);
    }
}
