package com.rm.lak;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogParserTest extends AbstractLogAnalyzerTest {

    @Test
    void should_parse_log() {
        String log = "2026-06-15T10:45:32 INFO : Application started successfully";
        LogParser logParser = new LogParser();
        LogEntry logEntry =   logParser.parse(log);
        Assertions.assertThat(logEntry.getLevel()).isEqualTo(LogLevel.INFO);
        Assertions.assertThat(logEntry.getMessage()).isEqualTo("Application started successfully");
        Assertions.assertThat(logEntry.getTime()).isEqualTo("2026-06-15T10:45:32");
    }
    @Test
    void should_parse_log_if_more_space_in_middle() {
        String log = "2026-07-10T10:00:00        INFO     :      User login";
        LogParser logParser = new LogParser();
        LogEntry logEntry =   logParser.parse(log);
        Assertions.assertThat(logEntry.getLevel()).isEqualTo(LogLevel.INFO);
        Assertions.assertThat(logEntry.getMessage()).isEqualTo("User login");
        Assertions.assertThat(logEntry.getTime()).isEqualTo("2026-07-10T10:00:00");
    }

    @Test
    void should_parse_log_if_more_leading_and_trailing_space() {
        String log = "               2026-07-10T10:00:00        INFO     :      User login              ";
        LogParser logParser = new LogParser();
        LogEntry logEntry =   logParser.parse(log);
        Assertions.assertThat(logEntry.getLevel()).isEqualTo(LogLevel.INFO);
        Assertions.assertThat(logEntry.getMessage()).isEqualTo("User login");
        Assertions.assertThat(logEntry.getTime()).isEqualTo("2026-07-10T10:00:00");
    }

}
