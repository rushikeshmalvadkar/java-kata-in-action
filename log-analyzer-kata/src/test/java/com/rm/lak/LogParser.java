package com.rm.lak;

import java.time.LocalDateTime;

public class LogParser {
    public  LogEntry parse(String log) {
        String[] logSplit = log.trim().split(" ",3);
        String date = logSplit[0];
        String level =logSplit[1];
        String message =logSplit[2];
        return LogEntry.of(date,level , message);
    }
}
