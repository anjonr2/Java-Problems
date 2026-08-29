package com.java.problem.predicate;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateDemo {
    public static void main(String [] args){
        Predicate<String> predicate = String::isEmpty;

        System.out.println(predicate.test(""));
        System.out.println(predicate.test("test"));

        System.out.println("---------------------");

        Function<String, Integer> f1 = String::length;
        System.out.println(f1.apply("Test"));

        Function<Integer, Integer> sqOfNum = (num) -> num * num;
        System.out.println("Square of "+ 4 + " is "+ sqOfNum.apply(4));

        System.out.println("-------------------------------");

        Consumer<String> c1 = (name) -> System.out.println("My name is : "+name);

        c1.accept("Rohit");

        System.out.println("-------------");

        Supplier<Integer> s1 = () -> {
          return 1;
        };

       int num =  s1.get();
       System.out.println("Supplier value : "+ num);

       Supplier<String> s2 = () ->{
         return "test1"+"-"+"test2";
       };

       System.out.println(s2.get());
    }
}
