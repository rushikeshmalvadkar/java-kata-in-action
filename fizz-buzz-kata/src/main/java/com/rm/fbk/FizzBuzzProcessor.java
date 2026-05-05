package com.rm.fbk;

public class FizzBuzzProcessor {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZ_BUZZ = FIZZ + BUZZ;

    public String process(int number) {
        if(isDivisibleByFiveAndThree(number)) return FIZZ_BUZZ;
        if(isDivisibleByThree(number)) return FIZZ;
        if(isDivisibleByFive(number)) return BUZZ;
        return Integer.toString(number);
    }

    private   boolean isDivisibleByFive(int input) {
        return input % 5 == 0;
    }

    private   boolean isDivisibleByThree(int input) {
        return input % 3 == 0;
    }

    private boolean isDivisibleByFiveAndThree(int input) {
        return input % 3 == 0 && input % 5 == 0;
    }


}
