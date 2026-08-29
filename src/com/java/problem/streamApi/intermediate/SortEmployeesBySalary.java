package com.java.problem.streamApi.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployeesBySalary {
    public static void main(String [] args){
        List<Employee> employees = Arrays.asList(
                new Employee(101, "John", 50000),
                new Employee(102, "Alice", 70000),
                new Employee(103, "Bob", 45000),
                new Employee(104, "David", 90000)
        );

        List<Employee> listAscending = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }
}
