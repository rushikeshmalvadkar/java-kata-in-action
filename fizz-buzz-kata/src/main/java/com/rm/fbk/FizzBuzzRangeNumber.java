package com.rm.fbk;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public record FizzBuzzRangeNumber(int startNumber, int endNumber) {
    static final String NEW_LINE = "\n";

    public String rangeProcess() {
        return IntStream.rangeClosed(startNumber(), endNumber())
                .boxed()
                .map(number -> FizzBuzzNumber.of(number).process())
                .collect(joining(NEW_LINE));
    }
}