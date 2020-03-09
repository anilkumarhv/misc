package com.company.java8;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StaticBlock {
    static boolean flag;
    static int B, H;

    static {
        Scanner input = new Scanner(System.in);
        B = input.nextInt();
        H = input.nextInt();
        if (B > 0 && H > 0) {
            flag = true;
        } else {
            System.out.print("java.lang.Exception: Breadth and height must be positive");
        }
        Locale indiaLocale = new Locale("en", "IN");

        String us = NumberFormat.getCurrencyInstance(Locale.US).format(12324.134);
        String india = NumberFormat.getCurrencyInstance(indiaLocale).format(12324.134);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(12324.134);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(12324.134);
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String pattern = in.nextLine();

            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (Exception e) {
                System.out.println("Invalid");
            }
            testCases--;
        }

        String zeroTo255 = "(\\d{1,2}|([01])\\d{2}|2[0-4]\\d|25[0-5])";
        final String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

        Pattern p = Pattern.compile(pattern);
//        Matcher m=p.matcher("000.168.1.2");
        Matcher m = p.matcher("900.000.1.2");
        System.out.println(m.find());

    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }

}
