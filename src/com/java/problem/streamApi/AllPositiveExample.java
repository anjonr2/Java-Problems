package com.java.problem.streamApi;

import java.util.List;

public class AllPositiveExample {
    public static void main(String [] args){
        List<Integer> numbers = List.of(1,2,3,4,5);

        boolean match = numbers.stream().allMatch(n->n>0);
    }
}
