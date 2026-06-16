package com.rm.lak;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogParserTest {

    @Test
    void should_parse_log() {
        String log = "2026-06-15T10:45:32 INFO : Application started successfully";
        LogParser logParser = new LogParser();
        LogEntry logEntry =   logParser.parse(log);
        Assertions.assertThat(logEntry.getLevel()).isEqualTo(LogLevel.INFO);
        Assertions.assertThat(logEntry.getMessage()).isEqualTo("Application started successfully");
        Assertions.assertThat(logEntry.getTime()).isEqualTo("2026-06-15T10:45:32");
    }
}
