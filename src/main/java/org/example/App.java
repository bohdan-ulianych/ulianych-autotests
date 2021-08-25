package org.example;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int a = 5;
        int[] arr = {5, 5, 2, 5, 13, 5, 1, 6, 7, 1, 56, 67, 65};
        String firtSrting = "x";
        String secondSrting = "0";
        char[] bbb = {'s', 't', 'r', 'o','o', 'k', 'a',};
        System.out.println(task1(arr));
        task2(arr, a);
        System.out.println(task3(firtSrting, secondSrting, a));
        task4(4);
        System.out.println(task5(bbb));
        System.out.println(task6("ноутбук","тобукун"));
    }

    public static boolean task1(int[] arr) {
        boolean a = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                a = true;
                break;
            } else {
                a = false;
            }
        }
        return a;
    }

    public static int[] task2(int[] arr, int a) {
        List res = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != a) {
                res.add(arr[i]);
            }
        }
        System.out.println(res);
        int[] mas = new int[res.size()];
        return mas;
    }

    public static String task3(String a, String b, int c) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < c; i++) {
            s.append(a);
            s.append(b);
        }
        s.deleteCharAt(c * 2 - 1);
        String str = s.toString();
        return str;
    }

    public static void task4(int n) {
        int[] arr = new int[n * (n + 1) / 2];
        int iterationCount = 1;
        int tVal = 1;
        arr[0] = tVal;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == iterationCount) {
                tVal = 1;
                iterationCount++;
            } else {
                tVal++;
            }
            arr[i] = tVal;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("");
    }

        public static boolean check(char a, char[] arr){
        boolean b=false;
        int count=0;
        for(int i =0; i<arr.length; i++){
            if(arr[i]==a){
                count++;
            }}
            if (count>=2)
                b=true;
           return b;
        }

        public static Object task5(char[] arr){
        Map<Character,Boolean> lhmap = new LinkedHashMap<>();
        boolean b = false;
        for(int i=0; i< arr.length; i++){
            lhmap.put(arr[i],check(arr[i],arr));
        }
        return lhmap;
    }

    public static String sort(String a) {
        char[] b = a.toCharArray();
        Arrays.sort(b);
        return new String(b);
    }
    public static boolean task6 (String a,String b) {
        if (a.length() != b.length()) {
            return false;
        }
        return sort(a).equals(sort(b));
    }

}
