package com.rm.fbk;


import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractFizzBuzzTest {

    protected   FizzBuzzProcessor fizzBuzzProcessor;

    @BeforeEach
    void setUp() {
        fizzBuzzProcessor = new FizzBuzzProcessor();
    }

}
