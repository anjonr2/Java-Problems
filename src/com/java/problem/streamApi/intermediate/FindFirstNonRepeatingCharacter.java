package com.java.problem.streamApi.intermediate;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingCharacter {
    public static void main(String [] args){
        String str = "swiss";

        Map<Character, Long> map = str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));

        /**
         * LinkedHashMap :: new is used to maintain insertion order
         * since Map doesn't maintain the insertion order
         */

        Optional<Map.Entry<Character, Long>> first = map
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst();


    }
}
