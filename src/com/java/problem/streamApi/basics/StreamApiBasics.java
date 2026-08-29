package com.java.problem.streamApi.basics;

import com.java.problem.streamApi.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiBasics {
    public static void main(String[] args){
        Predicate<Integer> isEven = (num) ->{
            return num %2==0;
        };

        Function<Integer, Integer> square = (num) -> num * num;

        Consumer<Integer> print = System.out::println;

        List<EmployeeDemo> employees =  Arrays.asList(
                new EmployeeDemo(1,"Amit", "Tech"),
                new EmployeeDemo(2,"Neha", "HR"),
                new EmployeeDemo(3,"Rahul", "Tech"),
                new EmployeeDemo(4,"Priya", "Finance"),
                new EmployeeDemo(5,"Vikas", "Tech"),
                new EmployeeDemo(6,"Sneha", "Marketing"),
                new EmployeeDemo(7,"Arjun", "Tech")
        );

        /**
         * Name of all employees
         * whose department is Tech
         */
        List<String> tech = employees.stream()
                .filter((employee) -> employee.getDepartment().equalsIgnoreCase("Tech "))
                .map(EmployeeDemo::getName)
                .collect(Collectors.toList());

        /**
         * Convert this list of employee
         * into a map
         * whose key is id
         * and value is name
         */

        //first functional interface which has all the id
        Function<EmployeeDemo, Integer> f1 = EmployeeDemo::getId;

        Function<EmployeeDemo, String> f2 = EmployeeDemo::getName;

        Map<Integer, String> employeeMap = employees.stream()
                .collect(Collectors.toMap(f1, f2));


        IntStream intStream = IntStream.range(1,10);
        intStream.average();
    }
}
