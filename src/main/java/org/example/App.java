package org.example;

import com.google.common.base.Splitter;
import org.example.AbsractFactory.BMWFactory;
import org.example.AbsractFactory.CarsFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        //Singleton
        //////////////////////////////////////////////////
        SingletonEnum singleton = SingletonEnum.INSTANCE;
        singleton.getValue();//0
        singleton.setValue(2);
        singleton.getValue();//2

        SingletonEnum sing = SingletonEnum.INSTANCE;
        sing.getValue();//2
        sing.setValue(25);
        sing.getValue();//25
        System.out.println(singleton == sing);//true
        ////////////////////////////////////////////////////
        //Builder
        PersonBuilder Person1 = new PersonBuilder.Builder()
                .withName("Bohdan")
                .withSurname("Ulianych")
                .withAge(21)
                .withHeight(179)
                .withWeight(62)
                .build();
        ///////////////////////////////////////////////////
        //AbstractFactory
        CarsFactory factory;
        factory = new BMWFactory();
        factory.createSedan();
        ///////////////////////////////////////////////////
        //Факториалы рекурсивный/нерекурсивный/через стрим
        int a = 7;
        System.out.println(a + "! = " + notRecursiveFact(a));
        System.out.println(a + "! = " + recursiveFact(a));
        System.out.println(a + "! = " + streamFact(a));
        //////////////////////////////////////////////////
        //Числа фибоначчи рекурсивный/нерекурсивный/через стрим
        System.out.print("Первые " + a + " чисел Фибоначчи: ");
        notRecursiveFibonacci(a);
        System.out.println("");
        System.out.println(a + " число Фибоначчи: " + recursiveFibonacci(a));
        System.out.print("Первые " + a + " чисел Фибоначчи: ");
        streamFibonacci(a);
        System.out.println("");
        //////////////////////////////////////////////////
        //Разбиение строки на подстроки фиксированной длинны. Самый простой для меня способ
        // - с помощью Google Guava
        for (final String token :
                Splitter
                        .fixedLength(4)
                        .split("Один в поле не воин")) {
            System.out.println(token);
        }
        //разбить строку на слова
        String str = "Один в поле не воин";
        String[] words = str.split(" ");
        for (String subStr : words) {
            System.out.println(subStr);
        }
        ///////////////////////////////////////////////////
        //Задача на коллекции
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> h = list.stream()
                .map(number -> number % 2 == 0 ? number * 100 : number - 100)
                .collect(Collectors.toList());
        System.out.println(h);
    }

    public static int notRecursiveFact(int a) {
        int value = 1;
        if (a < 0) {
            System.out.println("a<0");
        } else if (a == 0) {
            return value;
        } else {
            for (int i = 1; i <= a; i++) {
                value = value * i;
            }
        }
        return value;
    }

    public static int recursiveFact(int a) {
        int value = 1;
        if (a < 0) {
            System.out.println("a<0");
        } else if (a == 0) {
            return value;
        } else {
            value = a * recursiveFact(a - 1);
        }
        return value;
    }

    public static int streamFact(int a) {
        if (a <= 1) {
            return 1;
        } else {
            return IntStream.rangeClosed(2, a).reduce((x, y) -> x * y).getAsInt();
        }
    }

    public static void notRecursiveFibonacci(int a) {
        int arr[] = new int[a];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + ",");
        }
    }

    public static int recursiveFibonacci(int a) {
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        } else {
            return recursiveFibonacci(a - 1) + recursiveFibonacci(a - 2);
        }
    }

    public static void streamFibonacci(int a) {
        Stream.iterate(new int[]{1, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(a)
                .map(y -> y[0])
                .forEach(x -> System.out.print(x + ","));
    }
}



