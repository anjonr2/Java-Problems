package com.java.problem.streamApi.intermediate;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostFrequentCharInAString  {
    public static void main(String [] args){
        String input = "banana";

        Map<Character, Long> map = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
    }
}
