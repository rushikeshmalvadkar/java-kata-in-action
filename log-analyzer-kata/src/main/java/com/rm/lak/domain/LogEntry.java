package com.rm.lak.domain;


import com.rm.lak.enums.LogLevel;
import com.rm.lak.exceptions.InvalidLogEntryException;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogEntry {
    private static final String LOG_FORMAT_REGEX = "^(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2})\\s+(INFO|WARN|ERROR)\\s+:\\s+(.+)$";

    private final LocalDateTime time;
    private final LogLevel level;
    private final String message;


    public static LogEntry of(String time, String level, String message) {
        return new LogEntry(
                LocalDateTime.parse(time),
                LogLevel.valueOf(level),
                message
        );
    }

    public static LogEntry parse(String singleLogEntry) {
        validate(singleLogEntry);
        return parseValid(singleLogEntry);
    }

    private static void validate(String singleLogEntry) {
        if (isNotValid(singleLogEntry)) throw new InvalidLogEntryException();
    }

    private static boolean isNotValid(String singleLogEntry) {
        return !singleLogEntry.trim().matches(LOG_FORMAT_REGEX);
    }

    private static LogEntry parseValid(String singleLogEntry) {
        String[] logEntryParts = singleLogEntry.split("\\s+:\\s+");
        String logEntryNonMessagePart = logEntryParts[0].trim();
        String logEntryMessagePart = logEntryParts[1].trim();
        String[] logEntryNonMessageParts = logEntryNonMessagePart.split("\\s+");
        String timeStamp = logEntryNonMessageParts[0];
        String logLevel = logEntryNonMessageParts[1];
        return of(timeStamp, logLevel, logEntryMessagePart);
    }

    public  String format() {
       return String.format("%s %s : %s",
                time ,level, message
                       );
    }

    public  boolean isBetweenAndInclusiveRange(LocalDateTime startTime, LocalDateTime endtime) {
        return (time.isAfter(startTime) || time.isEqual(startTime)) && (time.isBefore(endtime) || time.isEqual(endtime));
    }
}
