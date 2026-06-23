package com.rm.lak;

import com.rm.lak.domain.LogEntry;
import com.rm.lak.domain.LogFile;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class LogsOfBetweenTimeRangeTest extends AbstractLogAnalyzerTest {

    @Test
    void should_return_logs_between_times_stamp_range() {
        String logs = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T11:05:10 INFO : User logout
                2026-07-10T11:20:05 ERROR : Database unavailable
                """;
        LogFile logFile = LogFile.from(logs);
        LocalDateTime start = LocalDateTime.parse("2026-07-10T10:10:00");
        LocalDateTime end = LocalDateTime.parse("2026-07-10T11:10:00");

        List<LogEntry> logsBetweenRange = logFile.findLogsBetween(start, end);
        Assertions.assertThat(logsBetweenRange)
                .containsExactly(
                        LogEntry.of("2026-07-10T10:15:30", "WARN", "High memory usage"),
                        LogEntry.of("2026-07-10T10:45:12", "ERROR", "Payment failed"),
                        LogEntry.of("2026-07-10T11:05:10", "INFO", "User logout")
                );

    }
    @Test
    void should_return_empty_if_logs_not_available_between_range() {
        String logs = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T11:05:10 INFO : User logout
                2026-07-10T11:20:05 ERROR : Database unavailable
                """;
        LogFile logFile = LogFile.from(logs);
        LocalDateTime start = LocalDateTime.parse("2026-07-10T10:00:01");
        LocalDateTime end = LocalDateTime.parse("2026-07-10T10:15:29");

        List<LogEntry> logsBetweenRange = logFile.findLogsBetween(start, end);
        Assertions.assertThat(logsBetweenRange).isEmpty();


    }
    @Test
    void should_return_logs_between_range_with_include_start_time() {
        String logs = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                """;
        LogFile logFile = LogFile.from(logs);
        LocalDateTime start = LocalDateTime.parse("2026-07-10T10:00:00");
        LocalDateTime end = LocalDateTime.parse("2026-07-10T10:10:00");

        List<LogEntry> logsBetweenRange = logFile.findLogsBetween(start, end);
        Assertions.assertThat(logsBetweenRange).
                containsExactly(
                        LogEntry.of("2026-07-10T10:00:00", "INFO", "User login")
                );


    }
}
