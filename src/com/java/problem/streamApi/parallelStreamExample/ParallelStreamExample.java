package com.java.problem.streamApi.parallelStreamExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String [] args){
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Amit", "IT", 70000),
                new Employee("Sneha", "Finance", 80000),
                new Employee("Vikram", "Finance", 75000),
                new Employee("Pooja", "HR", 60000),
                new Employee("Arjun", "IT", 95000),
                new Employee("Kavya", "Marketing", 65000),
                new Employee("Rohit", "Marketing", 72000),
                new Employee("Anjali", "HR", 58000)
        ));

        long startTime = System.currentTimeMillis();
        /**
         * Prints the name in the same order. As it is there in input
         * it doesn't alter the order, it maintains the order of input
         */
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
        long endTime = System.currentTimeMillis();

        System.out.println("Total time taken by seq. stream "+ (endTime - startTime));

        /**
         * In parallel stream order is not maintained
         * It will be in random order not as per original as
         * we have in input
         */
        startTime = System.currentTimeMillis();
        employees.parallelStream()
                .map(Employee::getName)
                .forEach(System.out::println);

        endTime = System.currentTimeMillis();

        System.out.println("Time taken by parallel stream "+ (endTime - startTime));
        /**
         * To maintain the order in parallelstream
         * we can use forEachOrdered() method instead of forEach()
         */

        employees.stream()
                .map(Employee::getName)
                .forEachOrdered(System.out::println);
    }
}
