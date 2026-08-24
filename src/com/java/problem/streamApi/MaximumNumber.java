package com.java.problem.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MaximumNumber {
    public static void main(String [] args){
        List<Integer> numbers = Arrays.asList(5, 10, 2, 8, 20);

        Optional<Integer> max = numbers.stream()
                .reduce((a,b)-> Math.max(a,b));
        System.out.println(max);
    }
}
