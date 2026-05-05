package com.rm.fbk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzProcessorTest {

    @Test
    void should_return_1_if_input_number_is_1() {

        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();

        String result = fizzBuzzProcessor.process(1);
        Assertions.assertThat(result).isEqualTo("1");
    }

    @Test
    void should_return_2_if_input_number_is_2() {

        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();

        String result = fizzBuzzProcessor.process(2);
        Assertions.assertThat(result).isEqualTo("2");
    }
}
