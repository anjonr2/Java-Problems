package com.java.problem.streamApi.intermediate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentEmployeeCount {
    public static void main(String [] args){
        List<Employee> employees = List.of(
                new Employee(1, "John", "IT", 60000),
                new Employee(2, "Alice", "HR", 55000),
                new Employee(3, "Bob", "IT", 75000),
                new Employee(4, "Carol", "HR", 70000),
                new Employee(5, "David", "Finance", 65000),
                new Employee(6, "Eve", "IT", 80000),
                new Employee(7, "Frank", "Finance", 64000),
                new Employee(8, "Ala", "Operations", 44000)
        );

        Map<String, Long> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        List<String> collect = map.entrySet()
                .stream()
                .filter(e -> e.getValue() > 2)
                .map(e -> e.getKey())
                .collect(Collectors.toList());


        /**
         * Find the department
         * with highest avg salary
         */

        Map<String, Double> collect1 = employees
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        Map.Entry<String, Double> result = collect1
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

    }
}
