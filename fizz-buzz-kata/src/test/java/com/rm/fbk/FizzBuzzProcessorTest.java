package com.rm.fbk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FizzBuzzProcessorTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            1,1
            4,4
            7,7
            """)
    void should_return_as_it_value_if_input_not_divisible_by_three_or_five(int input,String result) {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(input)).isEqualTo(result);
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
