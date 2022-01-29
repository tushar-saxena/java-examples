package com.ts.javaexamples.employee;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i=1; i <=20; i++) {
            System.out.println("iterating time = "+i);
            if(i % 2 == 0){
                System.out.println("its even number");
                list1.add(i);
            }else{
                System.out.println("its odd number");
                list2.add(i);
            }
        }
        System.out.println("even numbers"+list1);
        System.out.println("odd numbers"+list2);
    }
}
