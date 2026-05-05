package com.rm.fbk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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


    @ParameterizedTest
    @CsvSource(textBlock = """
            3,Fizz
            9,Fizz
            12,Fizz
            """)
    void should_return_Fizz_if_input_number_which_is_divisible_by_three(int input,String result) {

        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();

        String output = fizzBuzzProcessor.process(input);
        Assertions.assertThat(output).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            5,Buzz
            25,Buzz
            20,Buzz
            """)
    void should_return_Buzz_if_input_number_which_is_divisible_by_5(int input,String result) {

        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();

        String output = fizzBuzzProcessor.process(input);
        Assertions.assertThat(output).isEqualTo(result);
    }
}
