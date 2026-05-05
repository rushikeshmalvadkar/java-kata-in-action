package com.rm.fbk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FizzBuzzProcessorTest {

    @Test
    void should_return_1_if_input_number_is_1() {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(1)).isEqualTo("1");
    }

    @Test
    void should_return_2_if_input_number_is_2() {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(2)).isEqualTo("2");
    }


    @ParameterizedTest
    @CsvSource(textBlock = """
            3,Fizz
            9,Fizz
            12,Fizz
            """)
    void should_return_Fizz_if_input_number_which_is_divisible_by_three(int input,String result) {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            5,Buzz
            25,Buzz
            20,Buzz
            """)
    void should_return_Buzz_if_input_number_which_is_divisible_by_5(int input,String result) {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            15,FizzBuzz
            30,FizzBuzz
            45,FizzBuzz
            """)
    void should_return_FizzBuzz_if_input_number_which_is_divisible_by_5_and_3(int input,String result) {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(input)).isEqualTo(result);
    }
}
