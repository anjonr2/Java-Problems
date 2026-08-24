package com.java.problem.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String [] args){
        List<Integer> numbers = Arrays.asList(5,2,8,2,3,5,9,3);

        //Since set only stores unique elements
        //so we can convert this list to set() to have
        //unique elements only
        Set<Integer> uniqueNumbers =
        numbers.stream().collect(Collectors.toSet());

        List<Integer> uniqueNumbersList = numbers
                .stream()
                .distinct().collect(Collectors.toList());
    }
}
