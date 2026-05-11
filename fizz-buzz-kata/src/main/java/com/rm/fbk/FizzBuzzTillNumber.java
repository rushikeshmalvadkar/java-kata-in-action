package com.rm.fbk;

public record FizzBuzzTillNumber(int value) {

    static final int START_FROM_ONE = 1;

    public static FizzBuzzTillNumber of(int value) {
        return new FizzBuzzTillNumber(value);
    }

    public String tillNumberProcess() {
        return new FizzBuzzRangeNumber(START_FROM_ONE, value()).rangeProcess();
    }
}