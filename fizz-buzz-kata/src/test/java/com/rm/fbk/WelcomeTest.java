package com.rm.fbk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WelcomeTest {
    @Test
    void should_welcome() {
        String welcomeText = "welcome";
        Assertions.assertThat(welcomeText).isEqualTo("welcome");
    }
}
