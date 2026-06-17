package com.rm.lak;

import com.rm.lak.exceptions.InvalidLogEntryException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LogInValidEntryParseTest extends AbstractLogAnalyzerTest {
    @Test
    void should_throw_invalid_log_entry_exception_with_message_timestamp_missing_when_passed_log_message_without_timestamp() {
        assertThatThrownBy(() -> LogEntry.parse("INFO : login"))
                .isInstanceOf(InvalidLogEntryException.class)
                .isInstanceOf(InvalidLogEntryException.class)
                .hasMessage("Invalid log entry, please provide valid log entry(e.g 2026-07-10T10:00:00 INFO : User login)");
    }
}
