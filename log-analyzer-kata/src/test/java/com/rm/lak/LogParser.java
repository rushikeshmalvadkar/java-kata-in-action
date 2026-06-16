package com.rm.lak;

import org.jspecify.annotations.NonNull;

public class LogParser {
    public LogEntry parse(String log) {
        return prepareLogEntry(log);
    }

    private static @NonNull LogEntry prepareLogEntry(String log) {
        String[] logSplit = log.trim().split(" : ");
        String partOneOfLogSplit = logSplit[0];
        String[] partOneSplit = partOneOfLogSplit.split(" ");
        String partTwoOfLogSplit = logSplit[1];
        String date = partOneSplit[0];
        String logLevel = partOneSplit[1];
        return LogEntry.of(date, logLevel, partTwoOfLogSplit);
    }

}
