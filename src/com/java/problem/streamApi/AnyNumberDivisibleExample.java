package com.java.problem.streamApi;

import java.util.Arrays;
import java.util.List;

public class AnyNumberDivisibleExample {
    public static void main(String [] args){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        boolean match = numbers.stream()
                .anyMatch(n->n%3==0);
    }
}
