package com.rm.lak.domain;

import com.rm.lak.enums.LogLevel;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Data
public class LogFile {
    private final List<LogEntry> logEntries;

    public static LogFile from(String logs) {
        List<LogEntry> logEntries = logs.lines()
                .map(LogEntry::parse)
                .toList();
        return new LogFile(logEntries);
    }

    public List<LogEntry> entries() {
        return logEntries;
    }

    public long entryCount() {
        return logEntries.size();
    }

    public Map<LogLevel, Long> groupBy(Supplier<Function<LogEntry, LogLevel>> supplier) {
        return logEntries.stream()
                .collect(groupingBy(supplier.get(), counting()));
    }
}
