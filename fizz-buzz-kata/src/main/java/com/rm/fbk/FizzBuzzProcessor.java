package com.rm.fbk;

public class FizzBuzzProcessor {

    public String process(int input) {
        if(input%3==0) return "Fizz";
        return Integer.toString(input);
    }

}
