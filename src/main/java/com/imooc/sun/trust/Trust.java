package com.imooc.sun.trust;

import java.util.ArrayList;
import java.util.List;

public class Trust {
    public static void main(String[] args) {
        int[] arr = {100, 101, 102};
        OUTER:
        while (true) {
            for (int i = 0; i < arr.length; i++) {
                if (i == 1) {
                    break OUTER;
                } else {
                    System.out.println("A");
                }
            }
            System.out.println("B");
        }
        System.out.println("C");


        System.out.println(func(2));

        List<String> strList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();
        System.out.println("start");
//        objList = strList;
        System.out.println("end");
    }

    public static int func(int n) {
        int[] number = {1, 2, 3, 4};
        try {
            int ret = number[n] * 2;
            return ret;
        } catch (Exception e) {
            return n * 3;
        } finally {
            if (n == 2) {
                return 0;
            }
        }
    }
}
