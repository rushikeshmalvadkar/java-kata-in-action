package com.rm.lak;

import com.rm.lak.exceptions.InvalidLogEntryException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LogInValidEntryParseTest extends AbstractLogAnalyzerTest {
    @Test
    void should_throw_invalid_log_entry_exception_with_message_timestamp_missing_when_passed_log_message_without_timestamp() {
        LogParser logParser = new LogParser();
        assertThatThrownBy(() -> logParser.parse("INFO : login"))
                .isInstanceOf(InvalidLogEntryException.class)
                .hasMessage("Missing Timestamp");
    }
}
