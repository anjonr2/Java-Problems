package com.java.problem.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SqaureNumbers {
    public static void main(String [] args){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        List<Integer> squares = numbers.stream().map(number -> number * number).collect(Collectors.toUnmodifiableList());
        System.out.println(squares);
    }
}
