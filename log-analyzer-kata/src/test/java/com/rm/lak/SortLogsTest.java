package com.rm.lak;

import com.rm.lak.domain.LogFile;
import com.rm.lak.enums.Sort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SortLogsTest extends AbstractLogAnalyzerTest{
    @Test
    void should_return_logs_sorted_by_time_stamp() {

        String logs = """
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                """;
        LogFile logFile = LogFile.from(logs);
        String sortedLogs = logFile.sortByTimeStamp(Sort.ASC);
        Assertions.assertThat(sortedLogs)
                .isEqualTo("""
                             2026-07-10T10:00 INFO : User login
                             2026-07-10T10:15:30 WARN : High memory usage
                             2026-07-10T10:45:12 ERROR : Payment failed"""
                             );

    }

    @Test
    void should_return_entries_sort_by_timestamp_in_desc_order() {
        String logEntries = """
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                """;
        LogFile logFile = LogFile.from(logEntries);

        assertThat(logFile.sortByTimeStamp(Sort.DESC)).isEqualTo("""
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T10:15:30 WARN : High memory usage
                2026-07-10T10:00 INFO : User login""");
    }
}
