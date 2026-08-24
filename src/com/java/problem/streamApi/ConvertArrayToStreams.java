package com.java.problem.streamApi;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertArrayToStreams {
    public static void main(String [] args){

        //Primitive type array
        int[] arrayInt = {1,2,3,4,5};

        /*If array is of type primitive data types like int in this case
         * We need to use .stream() method of Arrays class to convert it into stream
         */
        IntStream streamObj = Arrays.stream(arrayInt);

        streamObj.forEach(System.out::println);

        Integer [] arrayInteger = {7,8,9};
        /* If the array is of object type Integer
        * then we need to use Stream.of() method
        */
        Stream<Integer> objStream = Stream.of(arrayInteger);
        objStream.forEach(System.out::println);
    }

}
