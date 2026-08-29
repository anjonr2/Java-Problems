package com.java.problem.comparatorAndComparableExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorAndComparableDemo {
    public static void main(String[] args){
        Employee e1 = new Employee(1, "Sachit", 25);
        Employee e2 = new Employee(3, "Kunal", 21);
        Employee e3 = new Employee(4, "Sumit", 28);
        Employee e4 = new Employee(2, "Pushp", 31);
        Employee e5 = new Employee(5, "Manas", 18);

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                            new Employee(1, "Sachit", 25),
                            new Employee(3, "Kunal", 21),
                            new Employee(4, "Sumit", 28),
                            new Employee(2, "Pushp", 31),
                            new Employee(5, "Manas", 18)));

        Collections.sort(employees);

        print(employees);

        System.out.println("------------------------");
        /**
         * Sort using comparator
         * sorted employees by age
         */
        Collections.sort(employees, (employee1,employee2)->{
            if(employee1.getAge()==employee2.getAge()){
                return 0;
            } else if (employee1.getAge()> employee2.getAge()) {
                return 1;
            }else {
                return -1;
            }
        });

        print(employees);
    }

    public static void print(List<Employee> employees){
        for(Employee employee : employees){
            System.out.println("Id: "+ employee.getId() + " Name: "+ employee.getName() +
                    " Age: " + employee.getAge()  );
        }
    }
}
