package com.rm.lak.domain;

import com.rm.lak.enums.LogLevel;
import com.rm.lak.enums.Sort;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

@Data
public class LogFile {
    public static final String LINE_BREAK = "\n";
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

    public Map<LogLevel, Long> groupByLogLevel() {
        return logEntries.stream()
                .collect(groupingBy((LogEntry::getLevel), counting()));
    }

    public Map<String, Long> groupByHour() {
        return logEntries.stream()
                .collect(Collectors.groupingBy(LogFile::formatAsDateHourOnly, counting()));

    }

    public List<LogEntry> findByLogLevel(LogLevel logLevel) {
        Predicate<LogEntry> loglevelPredicate = (logEntry) -> logEntry.getLevel() == logLevel;
        return findBy(loglevelPredicate);

    }

    public List<LogEntry> findEntriesByMessage(String message) {
        Predicate<LogEntry> logMessage = (logEntry -> logEntry.getMessage().equals(message));
        return findBy(logMessage);

    }

    public List<LogEntry> findLogsBetween(LocalDateTime startTime, LocalDateTime endtime) {
        return logEntries.stream()
                .filter(logEntry -> logEntry.isBetweenAndInclusiveRange(startTime, endtime))
                .toList();

    }

    private List<LogEntry> findBy(Predicate<LogEntry> predicate) {
        return logEntries.stream()
                .filter(predicate)
                .toList();
    }

    private static String formatAsDateHourOnly(LogEntry logEntry) {
        LocalDateTime timestamp = logEntry.getTime();
        return format("%sT%s", timestamp.toLocalDate(), timestamp.getHour());
    }


    public String sortByTimeStamp(Sort sortBy) {
        return logEntries.stream()
                .sorted(LogEntry.comparingTimestamp(sortBy))
                .map(LogEntry::format)
                .collect(joining(LINE_BREAK));
    }
}
