package com.java.problem.streamApi;

import java.util.List;
import java.util.stream.Collectors;

public class JoinStringsExample {
    public static void main(String [] args){
        List<String> fruits = List.of("Apple", "Banana", "Avocado", "Mango", "Apricot");

        String result = fruits.stream()
                .collect(Collectors.joining(","));
    }
}
