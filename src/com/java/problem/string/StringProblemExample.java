package com.java.problem.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StringProblemExample {
    public static void main(String [] args){

        /**
         * Given a string
         * count how many times each character appears in that string
         */

        String str = "java#java$";

        Map<Character, Long> result = str.
                chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        System.out.println("count of freq of chars  "+result);

        /**
         * Given an array of strings
         * Task is to find the longest common prefix shared by all the strings in the array
         * If there is no common prefix return an empty string
         */

        List<String> words = Arrays.asList(
                "abc",
                "abcd",
                "abcde",
                "ab",
                "abcd",
                "abcdef"
        );

        /**
         * given a string
         * find first non repeated
         * characters
         */

        String word = "swiss";
        LinkedHashMap<Character, Long> map = word
                .chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors
                                .groupingBy(
                                        c -> c,
                                        LinkedHashMap::new,
                                        Collectors.counting()
                                )
                );

        Optional<Map.Entry<Character, Long>> firstNonRepeatingChar = map
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst();

        /**
         * Join list of strings
         */

        List<String> roles = List.of(
                "ADMIN",
                "USER",
                "MANAGER"
        );

        System.out.println("-------String joining--------");

        String stringjoining = roles
                .stream()
                .collect(Collectors.
                        joining("|"));

        System.out.println(stringjoining);

        /**
         * Count of occurences
         * of each element in a given
         * list
         */

        List<String> categories = Arrays.asList(
                "Electronics",
                "Clothing",
                "ELectronics",
                "Grocery",
                "ELectronics"
        );

        Map<String, Long> groupByCategories = categories
                .stream()
                .collect(Collectors.groupingBy(
                        el -> el,
                        Collectors.counting()
                ));
        System.out.println();
        System.out.println("-------Group by categories-------");
        System.out.println(groupByCategories);
    }
}
