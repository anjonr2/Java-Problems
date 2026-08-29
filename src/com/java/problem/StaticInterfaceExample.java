package com.java.problem;

public interface StaticInterfaceExample {
    int a = 10;
    int b = 20;

    static int sum(){
        return a + b;
    }
}
