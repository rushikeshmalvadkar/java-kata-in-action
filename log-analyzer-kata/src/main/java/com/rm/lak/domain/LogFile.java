package com.rm.lak.domain;

import lombok.Data;

import java.util.List;

@Data
public class LogFile {
    private final List<LogEntry> logEntries;

    public static LogFile from(String logs){
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
}
