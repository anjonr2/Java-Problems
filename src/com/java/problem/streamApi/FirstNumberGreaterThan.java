package com.java.problem.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FirstNumberGreaterThan {
    public static void main(String [] args){
        List<Integer> numbers = Arrays.asList(3,7,12,5,20,11);

        Optional<Integer> first = numbers.stream()
                                         .filter(n -> n>10)
                .sorted()
                                        .findFirst();

        System.out.println(first.orElse(0));
    }
}
