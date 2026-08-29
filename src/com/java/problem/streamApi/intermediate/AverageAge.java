package com.java.problem.streamApi.intermediate;

import java.util.Arrays;
import java.util.List;

public class AverageAge {
    public static void main(String [] args){
        List<Person> people = Arrays.asList(
                new Person("Alice",25),
                new Person("Bob",30),
                new Person("Charlie",28),
                new Person("David",35)
        );

        double avg = people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }
}
