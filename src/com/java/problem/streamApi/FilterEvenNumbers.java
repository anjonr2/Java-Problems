package com.java.problem.streamApi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterEvenNumbers {
    public static void main(String [] args){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Stream<Integer> stream = numbers.stream();

        List<Integer> evenNumbers =  stream.filter(n -> n%2 == 0).collect(Collectors.toUnmodifiableList());
        System.out.println(evenNumbers);
    }
}
