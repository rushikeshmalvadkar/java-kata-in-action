package com.rm.lak;

import com.rm.lak.domain.LogFile;
import com.rm.lak.enums.LogLevel;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LogFileLogLevelCountingTest extends AbstractLogAnalyzerTest {
    @Test
    void should_return_the_count_of_log_by_log_level() {
        String logEntries = """
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:01:00 WARN : High memory usage
                2026-07-10T10:02:00 ERROR : Payment failed
                """;
        LogFile logFile = LogFile.from(logEntries);
        Map<LogLevel,Long> result   = logFile.groupByLogLevel();
        assertThat(result)
                .containsEntry(LogLevel.INFO, 1L)
                .containsEntry(LogLevel.WARN, 1L)
                .containsEntry(LogLevel.ERROR, 1L)
                .hasSize(3);

    }
}
