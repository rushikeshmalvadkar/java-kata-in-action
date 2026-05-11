package com.rm.fbk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzRangeNumberTest extends AbstractFizzBuzzTest{

    @Test
    void should_return_output_of_fizz_buzz_based_on_range_between_5_9() {
        String result =  new FizzBuzzRangeNumber(5, 9).rangeProcess();
        Assertions.assertThat(result).isEqualTo("""
                  BuzzBuzz
                  Fizz
                  7
                  8
                  Fizz"""
                );

    }

    @Test
    void should_return_output_of_fizz_buzz_based_on_range_between_10_15() {
        String result =  new FizzBuzzRangeNumber(10, 15).rangeProcess();
        Assertions.assertThat(result).isEqualTo("""
                  Buzz
                  11
                  Fizz
                  Fizz
                  14
                  BuzzFizzBuzz"""
        );

    }
}
