package com.rm.fbk;

public record FizzBuzzNumber(int value) {

    static final String FIZZ = "Fizz";
    static final String BUZZ = "Buzz";
    static final String FIZZ_BUZZ = FIZZ + BUZZ;

    public static FizzBuzzNumber of(int value) {
        return new FizzBuzzNumber(value);
    }

    public String asString() {
        return Integer.toString(value());
    }

    boolean contains3() {
        return asString().contains("3");
    }

    public boolean contains5() {
        return asString().contains("5");
    }

    boolean isDivisibleByFive() {
        return value() % 5 == 0;
    }

    boolean isDivisibleByThree() {
        return value() % 3 == 0;
    }

    boolean isDivisibleByFiveAndThree() {
        return isDivisibleByFive() && isDivisibleByThree();
    }

    public boolean divisibilityBy3Or5() {
        return isDivisibleByThree() || isDivisibleByFive();
    }

    String divisibleBy3AndOr5() {
        if (isDivisibleByFiveAndThree()) return FIZZ_BUZZ;
        if (isDivisibleByThree()) return FIZZ;
        return BUZZ;
    }

    public String process() {
        StringBuilder builder = new StringBuilder();
        if (contains3()) builder.append(FIZZ);
        if (contains5()) builder.append(BUZZ);
        if (divisibilityBy3Or5()) builder.append(divisibleBy3AndOr5());
        String parsedNumber = builder.toString();
        return parsedNumber.isEmpty() ? asString() : parsedNumber;
    }
}