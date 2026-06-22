package com.rm.lak;

import com.rm.lak.domain.LogEntry;
import com.rm.lak.domain.LogFile;
import com.rm.lak.enums.LogLevel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFilterTest extends AbstractLogAnalyzerTest {

    @Test
    void should_return_logs_by_log_level_info() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:01:00 WARN : High memory usage
                2026-07-10T10:02:00 INFO : User logout
                2026-07-10T10:02:00 ERROR : Payment failed
                """;
        LogFile logFile = LogFile.from(logEntries);
        List<LogEntry> entries = logFile.findByLogLevel(LogLevel.INFO);
        assertThat(entries).containsExactly(
                LogEntry.of("2026-07-10T10:00:00", "INFO", "User login"),
                LogEntry.of("2026-07-10T10:02:00" ,"INFO","User logout")
        );
    }

    @Test
    void should_return_log_by_message() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:01:00 WARN : High memory usage
                2026-07-10T10:02:00 INFO : User logout
                2026-07-10T10:03:00 ERROR : User login
                """;
        LogFile logFile = LogFile.from(logEntries);
        List<LogEntry> entries = logFile.findEntriesByMessage("User login");
        assertThat(entries).containsExactly(
                LogEntry.of("2026-07-10T10:00:00", "INFO", "User login"),
                LogEntry.of("2026-07-10T10:03:00" ,"ERROR","User login")
        );
    }
}
