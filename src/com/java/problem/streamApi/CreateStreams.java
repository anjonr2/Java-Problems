package com.java.problem.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreams {
    public static void main(String [] args){
        List<String> names = Arrays.asList("nameA","nameB","nameC");

        /* List to streams */
        Stream<String> stream = names.stream();

        String [] array = {"Java", "Python", "C++"};
        /* If any array is provided then we can use Arrays.stream()
        and pass the array object to the stream method */
        Stream<String> streamObj = Arrays.stream(array);

        /*
        3rd way is using Stream.of() method
        * */
        Stream<Integer> integerStream =  Stream.of(1,2,3);
    }
}
