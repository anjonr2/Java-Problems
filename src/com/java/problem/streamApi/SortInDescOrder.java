package com.java.problem.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortInDescOrder {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(5,5,1,5,1,8,3,2,10);

        List<Integer> sortedInDesc =  numbers
                .stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
