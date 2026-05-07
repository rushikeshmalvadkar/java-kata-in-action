package com.rm.fbk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
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
            6,Fizz
            9,Fizz
            12,Fizz
            """)
    void should_return_Fizz_if_input_number_which_is_divisible_by_three(int input,String result) {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            40,Buzz
            80,Buzz
            20,Buzz
            """)
    void should_return_Buzz_if_input_number_which_is_divisible_by_5(int input,String result) {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            60,FizzBuzz
            120,FizzBuzz
            180,FizzBuzz
            """)
    void should_return_FizzBuzz_if_input_number_which_is_divisible_by_5_and_3(int input,String result) {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            13,Fizz
            23,Fizz
            """)
    void should_return_output_if_input_number_contains_3(int input,String result) {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            52,Buzz
            """)
    void should_return_output_if_input_number_contains_5(int input,String result) {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            53,FizzBuzz
            253,FizzBuzz
            503,FizzBuzz
            """)
    void should_return_output_if_input_number_contains_3_and_5(int input,String result) {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            153,FizzBuzzFizz
            351,FizzBuzzFizz
            """)
    void should_return_output_if_input_number_contains_3_and_5_and_divisible_by_3(int input, String result) {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            35,FizzBuzzBuzz
            """)
    void should_return_output_if_input_number_contains_3_and_5_and_divisible_by_5(int input, String result) {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(input)).isEqualTo(result);
    }

    @Test
    void should_return_output_for_till_number_three() {
        FizzBuzzProcessor fizzBuzzProcessor = new FizzBuzzProcessor();
        Assertions.assertThat(fizzBuzzProcessor.process(3)).isEqualTo("""
                1
                2
                Fizz
                """);
    }



}
