package com.java.problem.streamApi.intermediate;

import java.util.*;
import java.util.stream.Collectors;

public class HighestSalaryGroupByDepartment {
    public static void main(String [] args){
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "HR", 50000),
                new Employee(2, "Jane", "IT", 70000),
                new Employee(3, "Mike", "IT", 80000),
                new Employee(4, "Sara", "Finance", 60000),
                new Employee(5, "Paul", "HR", 55000)
        );

        Map<String, Optional<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        System.out.println(collect);
    }
}
