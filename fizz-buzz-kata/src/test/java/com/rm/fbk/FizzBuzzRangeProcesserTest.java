package com.rm.fbk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzRangeProcesserTest  extends AbstractFizzBuzzTest{

    @Test
    void should_return_output_of_fizz_buzz_based_on_range_between_5_9() {
        String result =  fizzBuzzProcessor.rangeProcess(5,9);
        Assertions.assertThat(result).isEqualTo("""
                  Buzz,
                  Fizz
                  7,
                  8,
                  Fizz"""
                );

    }
}
