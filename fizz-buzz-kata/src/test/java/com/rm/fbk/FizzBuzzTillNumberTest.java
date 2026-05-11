package com.rm.fbk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzTillNumberTest extends AbstractFizzBuzzTest {
    @Test
    void should_return_output_for_till_number_three() {
        Assertions.assertThat(FizzBuzzTillNumber.of(3).tillNumberProcess()).isEqualTo("""
                1
                2
                FizzFizz"""
        );
    }
}
