package com.java.problem.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumOfSquaresOfEvenNumbers {
    public static void main(String [] args){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Optional<Integer> sumOfEvenSqrs = Optional.of(numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n)
                .reduce(0, (a, b) -> a + b));

        System.out.println(sumOfEvenSqrs.get());
    }
}
