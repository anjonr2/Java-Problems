package com.java.streamApi;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighest {
    public static void main(String []args){
        List<Integer> numbers = Arrays.asList(10, 20, 35, 50, 50, 75, 65);
        Optional<Integer> secondLargest = numbers.stream()
                .distinct() // remove duplicates
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        secondLargest.ifPresent(System.out::println);
    }
}
