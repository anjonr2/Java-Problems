package com.java.problem.streamApi;

import java.util.Arrays;
import java.util.List;

public class SumOfElements {
    public static void main(String [] args){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        /* reduce is itself a terminal function
        so we don't need any terminal function at the end
        Since we had to reduce the list of 5 numbers into
        a single result of sum so we have used reduce() function
        of stream
        */
        Integer sum = numbers.stream().reduce(0, (a,b)->a+b);
        System.out.println(sum);
    }
}
