package in.anil.java;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Abc extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("a");
            System.out.println("b");

        }
    }
}

public class XXX extends Thread {
    @Override
    public void run() {
        System.out.println("sda");
//        yield();
//        System.out.println("sdaf");
//        for (int i = 0; i < 3; i++) {
//            System.out.println("c");
//            System.out.println("d");
//
//        }

    }
//    public void start(){
//        System.out.println("c");
//    }

    public static void main(String[] args) {
//        Abc a=new Abc();
//        XXX x=new XXX();
//        a.start();
//        x.start();
//        int z=10;
//        int y=5;
//        System.out.println("Res"+z-y);
        List l=new ArrayList();
//        l.add("10");
//        l.add("5");
//        l.add("6");
        XXX t=new XXX();
        XXX t1=new XXX();
        l.add(t);
        l.add(t1);
        Collections.sort(l);
        for (int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }
//        XXX t=new XXX();
//        XXX t1=new XXX();
//        t.run();
//        t1.run();

//        int i=0;
//        for (int i=0;i<3;i++){
//            System.out.println(i);
//        }



    }
}
