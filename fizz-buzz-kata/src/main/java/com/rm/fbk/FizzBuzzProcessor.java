package com.rm.fbk;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzProcessor {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZ_BUZZ = FIZZ + BUZZ;
    public static final String NEW_LINE = "\n";

    public String process(int number) {
        StringBuilder builder = new StringBuilder();
        if (contains3(number)) builder.append(FIZZ);
        if (contains5(number)) builder.append(BUZZ);
        if (divisibilityBy3Or5(number)) builder.append(divisibleBy3AndOr5(number));
        String parsedNumber = builder.toString();
        return parsedNumber.isEmpty() ? asString(number) :  parsedNumber;
    }

    public String tillNumberProcess(int input) {
        List<String> parseResults = new ArrayList<>();
        for (int i = 1; i <= input; i++) {
            parseResults.add(process(i));
        }
        return String.join(NEW_LINE, parseResults);
    }

    private static  String asString(int number) {
        return Integer.toString(number);
    }

    private boolean divisibilityBy3Or5(int input) {
        return isDivisibleByThree(input) || isDivisibleByFive(input);
    }

    private static boolean contains5(int input) {
        return asString(input).contains("5");
    }

    private static boolean contains3(int input) {
        return asString(input).contains("3");
    }

    private String divisibleBy3AndOr5(int number) {
        if (isDivisibleByFiveAndThree(number)) return FIZZ_BUZZ;
        if (isDivisibleByThree(number)) return FIZZ;
        return BUZZ;
    }

    private boolean isDivisibleByFive(int input) {
        return input % 5 == 0;
    }

    private boolean isDivisibleByThree(int input) {
        return input % 3 == 0;
    }

    private boolean isDivisibleByFiveAndThree(int input) {
        return isDivisibleByFive(input) && isDivisibleByThree(input);
    }

}
