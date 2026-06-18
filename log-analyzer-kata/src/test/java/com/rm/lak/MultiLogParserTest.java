package com.rm.lak;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiLogParserTest extends AbstractLogAnalyzerTest {

    @Test
    void should_parse_the_multi_log() {

        List<String> multiLog = List.of("2026-07-10T10:00:00 INFO : User login"
                , "2026-07-10T10:01:00 WARN : High memory usage"
                , "2026-07-10T10:02:00 ERROR : Payment failed");
        List<LogEntry> logEntries = LogEntry.multiParse(multiLog);
        assertThat(logEntries).hasSize(3);
        assertThat(logEntries.get(0))
                .extracting(
                        LogEntry :: getTime,
                        LogEntry::getLevel,
                        LogEntry::getMessage
                )
                .containsExactly(
                        LocalDateTime.parse("2026-07-10T10:00:00"),
                        LogLevel.INFO,
                        "User login"
                );
        assertThat(logEntries.get(1))
                .extracting(
                        LogEntry :: getTime,
                        LogEntry::getLevel,
                        LogEntry::getMessage
                )
                .containsExactly(
                        LocalDateTime.parse("2026-07-10T10:01:00"),
                        LogLevel.WARN,
                        "High memory usage"
                );
        assertThat(logEntries.get(2))
                .extracting(
                        LogEntry :: getTime,
                        LogEntry::getLevel,
                        LogEntry::getMessage
                )
                .containsExactly(
                        LocalDateTime.parse("2026-07-10T10:02:00"),
                        LogLevel.ERROR,
                        "Payment failed"
                );



    }
}
