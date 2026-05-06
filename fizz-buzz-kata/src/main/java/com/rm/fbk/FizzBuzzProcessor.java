package com.rm.fbk;

public class FizzBuzzProcessor {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZ_BUZZ = FIZZ + BUZZ;

    public String process(int number) {
        String outputOfContains = ContainsHas3And5(number);
        String finalOutPut = divisibleBy3AndOr5(number, outputOfContains);
        if (!finalOutPut.isEmpty()) return finalOutPut;
        return Integer.toString(number);
    }

    private String ContainsHas3And5(int input) {
        String inputInString = Integer.toString(input);
        StringBuilder containsOutPut = new StringBuilder();
        if (inputInString.contains("3")) {
            containsOutPut.append(FIZZ);
        }
        if (inputInString.contains("5")) {
            containsOutPut.append(BUZZ);
        }
        return containsOutPut.toString();
    }

    private String divisibleBy3AndOr5(int number, String containsOutput) {
        StringBuilder divisibleOutput = new StringBuilder(containsOutput);
        if (isDivisibleByFiveAndThree(number)) {
            return divisibleOutput.append(FIZZ_BUZZ).toString();
        }
        if (isDivisibleByThree(number)) {
            return divisibleOutput.append(FIZZ).toString();
        }
        if (isDivisibleByFive(number)) {
            return divisibleOutput.append(BUZZ).toString();
        }
        return divisibleOutput.toString();
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
