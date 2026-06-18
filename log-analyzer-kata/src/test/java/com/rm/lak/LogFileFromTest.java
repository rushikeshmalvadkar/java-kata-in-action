package com.rm.lak;

import com.rm.lak.domain.LogEntry;
import com.rm.lak.domain.LogFile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFileFromTest extends AbstractLogAnalyzerTest {

    @Test
    void should_parse_the_multi_log() {

        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:01:00 WARN : High memory usage
                2026-07-10T10:02:00 ERROR : Payment failed
                """;
        LogFile logFile = LogFile.from(logEntries);
        assertThat(logFile.entryCount()).isEqualTo(3L);
        assertThat(logFile.entries()).containsExactly(
                LogEntry.of("2026-07-10T10:00:00", "INFO", "User login"),
                LogEntry.of("2026-07-10T10:01:00", "WARN", "High memory usage"),
                LogEntry.of("2026-07-10T10:02:00", "ERROR", "Payment failed")
        );
    }
}
