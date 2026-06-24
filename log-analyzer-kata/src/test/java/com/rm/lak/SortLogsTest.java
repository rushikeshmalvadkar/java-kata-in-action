package com.rm.lak;

import com.rm.lak.domain.LogFile;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortLogsTest extends AbstractLogAnalyzerTest{
    @Test
    void should_return_logs_sorted_by_time_stamp() {

        String logs = """
                2026-07-10T10:45:12 ERROR : Payment failed
                2026-07-10T10:00:00 INFO : User login
                2026-07-10T10:15:30 WARN : High memory usage
                """;
        LogFile logFile = LogFile.from(logs);
        String sortedLogs = logFile.sortByTimeStampAsc();
        Assertions.assertThat(sortedLogs)
                .isEqualTo("""
                             2026-07-10T10:00 INFO : User login
                             2026-07-10T10:15:30 WARN : High memory usage
                             2026-07-10T10:45:12 ERROR : Payment failed"""
                             );

    }
}
