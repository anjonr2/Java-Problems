package com.java.problem.streamApi;

import java.util.List;
import java.util.Optional;

public class FirstNonEmptyString {
    public static void main(String [] args){
        List<String> strings = List.of("", "", "Hello", "World");

        Optional<String> result = strings.stream()
                .filter(s -> !s.isEmpty())
                .findFirst();

        System.out.println(result.get());
    }
}
