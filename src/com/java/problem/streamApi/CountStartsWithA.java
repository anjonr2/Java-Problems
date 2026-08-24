package com.java.problem.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountStartsWithA {
    public static void main(String[] args){
        List<String> fruits = Arrays.asList("Apple", "Banana", "Avocado", "Mango", "Apricot");

        List<String> result =  fruits.stream()
                .filter(fr->fr.startsWith("A"))
                .collect(Collectors.toList());
    }
}
