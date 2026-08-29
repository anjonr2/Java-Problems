package com.java.problem.streamApi.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Get avg of employees grouped by department
 */
public class GroupbyDepartment {
    public static void main(String [] args){
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "HR", 50000),
                new Employee(2, "Jane", "IT", 70000),
                new Employee(3, "Mike", "IT", 80000),
                new Employee(4, "Sara", "Finance", 60000),
                new Employee(5, "Paul", "HR", 55000)
        );

        Map<String, Double> avgSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(avgSalaryByDepartment);
    }
}
