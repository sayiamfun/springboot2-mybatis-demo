package com.sayiamfun.springboot2mybatisdemo;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoTest {


    public static void main(String[] args) {
        intAsList();
        stringAsList();
    }

    private static void stringAsList(){
        String[] array = {"欢迎","关注","Java"};
        for (String s : array) {
            System.err.println(s);
        }
        System.out.println("----------------------------------------------------------");
        List<String> list = Arrays.stream(array).collect(Collectors.toList());
        array[0] = "不欢迎";
        list.set(1,"退出");
        list.add("。");
        System.out.println("----------------------------------------------------------");
        System.out.println(list.size());
        System.out.println("----------------------------------------------------------");
        for (String s : list) {
            System.out.println(s);
        }

    }

    private static void intAsList(){
        int[] array = {1,2,3};
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("----------------------------------------------------------");
        List list = Arrays.stream(array).boxed().collect(Collectors.toList());
        list.add(4);
        System.out.println("----------------------------------------------------------");
        System.out.println(list.size());
        System.out.println("----------------------------------------------------------");
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
