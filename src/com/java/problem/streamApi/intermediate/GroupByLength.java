package com.java.problem.streamApi.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLength {
    public static void main(String [] args){
        List<String> words = Arrays.asList("apple", "bat", "ball", "cat", "banana", "dog", "goat");

        Map<Integer, List<String>> wordsByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(wordsByLength);

    }
}
