package com.java.problem.streamApi;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PracticeProblems {
    public static void main(String [] args){
        /*
        Given a list of integer
        remove duplicates
        and sort them in descending order
        * */
        List<Integer> list = new ArrayList<>(Arrays.asList(5,3,1,3,2,5,4));
        List<Integer> result = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        /*
        From a list find all the odd numbers
        and return their squares in a new list
        * */

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> result1 = list1.stream()
                .filter(el -> el % 2 != 0)
                .map(el -> el * el)
                .collect(Collectors.toList());

        /*
        We have a list of integer
        Get 2nd and 3rd elements from it
        and return them in a list
        * */

        List<Integer> list2 = Arrays.asList(10,20,30,40,50);
        List<Integer> result2 = list2.stream()
                .skip(1) //10 is skipped
                .limit(2) //limit till 30
                .collect(Collectors.toList());

        /*
        Find the 2nd highest number from a list of integer
        * */

        List<Integer> list3 = new ArrayList<>(Arrays.asList(20,10,10,45,30,45,5,20));
        Optional<Integer> result3 = list3.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        System.out.println(result3.get());

        /**
         * You have list of integer
         * Divide them into even and odd
         */

        List<Integer> list4 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Map<Boolean, List<Integer>> result4 = list4.stream()
                .collect(Collectors.partitioningBy(el -> el % 2 == 0));

        /**
         * When we have to split our data into two parts we have to use
         * partitioningBy() method of Collectors class
         */


        /**
         * Given a list of string find the longest string
         */

        List<String> list5 = new ArrayList<>(Arrays.asList("Java", "SpringBoot", "API"));

        Optional<String> result5 = list5.stream()
                .max(Comparator.comparing(el -> el.length()));


        /**
         * From a list of employees, find the first employee
         * whose salary is greater than 50000
         */

        List<Employee> employees = new ArrayList<>(
                Arrays.asList(
                        new Employee("Abhishek", "IT", 50000),
                        new Employee("Ankit", "IT", 70000),
                        new Employee("Rahul", "HR", 40000),
                        new Employee("Tina", "HR", 45000),
                        new Employee("Esha", "Finance", 60000),
                        new Employee("Naman", "Finance", 55000),
                        new Employee("Sachit", "IT", 80000),
                        new Employee("Pushp", "Marketing", 50000),
                        new Employee("Sumit", "Marketing", 52000)
                )
        );

        Optional<Employee> result6 = employees.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .findFirst();

        if(result6.isPresent()){
            System.out.println(result6.get());
        }

        /**
         * Top two highest paid employees
         */

        List<Employee> result7 = employees.stream()
                .sorted(Comparator.comparingInt(emp -> emp.getSalary()))
                .limit(2)
                .collect(Collectors.toList());

        /**
         * From a list of employees
         * Sort employees by salary,
         * then by name
         *
         * We need to sort them by salary
         * but if multiple employees have the same
         * salary
         * then we need to further sort them by name
         */

        List<Employee> list7 = employees.stream()
                .sorted((emp1, emp2) -> {
                    if (emp1.getSalary() > emp2.getSalary()) {
                        //need to swap for the employees to be sorted in salary
                        return 1;
                    } else if (emp1.getSalary() < emp2.getSalary()) {
                        //since emp1 salary is already less than emp2 salary so it is sorted no need to swap
                        return -1;
                    } else {
                        /**
                         * if salary of both
                         * emp1 and emp2 are equal
                         * compare on the basis of name
                         */
                        return emp1.getName().compareTo(emp2.getName());
                    }
                })
                .collect(Collectors.toList());

        /**
         * Find the frequency of each element from the list
         */

        List<Integer> list6 = new ArrayList<>(Arrays.asList(3,2,3,4,4,1,2,1,1,1,5,6,5));
        Map<Integer, Long> result8 = list6.stream()
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()));

        /**
         * Given a list of employees
         * count how many employees
         * are present in each department
         */

        Map<String, Long> result9 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        List<Transactions> transactions = new ArrayList<>(
                Arrays.asList(
                        new Transactions("Food",100),
                        new Transactions("Food",200),
                        new Transactions("Food",150),
                        new Transactions("Shopping",300),
                        new Transactions("Shopping",250),
                        new Transactions("Shopping",100),
                        new Transactions("Utilities",400),
                        new Transactions("Utilities",300),
                        new Transactions("Entertainment",500),
                        new Transactions("Entertainment",200),
                        new Transactions("Travel",700),
                        new Transactions("Travel",300)
                )
        );

        /**
         * Given a list of transactions
         * Find total transaction amount
         * per category
         */

        Map<String, Integer> txnAmtByCategory = transactions.stream()
                .collect(Collectors.groupingBy(transaction -> transaction.getCategory(), Collectors.summingInt(txn -> txn.getAmount())));


        /**
         * Find the avg salary of employees in each department
         */

        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartment(), Collectors.averagingInt(emp -> emp.getSalary())));


        /**
         * Given a list of employees
         * find highest paid employee in
         * each department
         */

        Map<String, Optional<Employee>> maxSalaryInEachDepartment = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getDepartment(), Collectors.maxBy(Comparator.comparingInt(emp -> emp.getSalary()))));

        /**
         * Given a list of employees
         * Convert the list into a comma-separated
         * string of Employee names
         */

        String namesSeparatedByComma = employees.stream()
                .map(emp -> emp.getName())
                .collect(Collectors.joining(","));

        /**
         * Given two lists
         * Find common elements between them
         */

        List<Integer> input1 = Arrays.asList(1,2,3,4);
        List<Integer> input2 = Arrays.asList(3,4,5,6);

        List<Integer> commonEl = input2.stream()
                .filter(el -> input1.contains(el))
                .collect(Collectors.toList());

        //2nd approach
        Set<Integer> set = new HashSet<>(input1);

        /**
         * List is converted to set
         * and input2 is iterated and filtered out elements
         * that are not present in set
         */
        List<Integer> commonElBetweenTwoList = input2.stream()
                .filter(el -> set.contains(el))
                .collect(Collectors.toList());


        /**
         * You have a List of Lists
         * Convert it into a single list
         * with all the elements
         * Remove duplicates if any
         */

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1,2,3,4),
                Arrays.asList(3,4,5,6),
                Arrays.asList(7,8,1,2),
                Arrays.asList(9,10,5,6),
                Arrays.asList(11,12,7,8)
        );

        List<Integer> distinctList = listOfLists.stream()
                .flatMap(innerList -> innerList.stream())
                .distinct()
                .collect(Collectors.toList());

        /**
         * Given a list of employees
         * Print all employee names
         * Their order doesn't matter
         * but the operation should be fast
         */

        /**
         * Since order doesn't matter
         * we should use multiple threads
         * for this we need to use parallelStream
         * instead of just stream
         * parallelStream() method will use multiple threads to process the stream
         */
        List<String> employeeNames = employees.parallelStream()
                .map(Employee::getName)
                .collect(Collectors.toList());


        /**
         * From a list of employee
         * Compute total combined Salary
         * of all the employees
         * Operation should be fast
         */

        Integer totalSalary = employees.parallelStream()
                .map(employee -> employee.getSalary())
                .reduce(0, (a, b) -> a + b);

    }


}