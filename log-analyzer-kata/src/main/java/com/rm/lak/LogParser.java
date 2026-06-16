package com.rm.lak;

public class LogParser {
    public LogEntry parse(String log) {

        String[] logSplit = log.split("\\s+:\\s+");
        String nonMessagePart = logSplit[0].trim();
        String[] splitNonMessagePart = nonMessagePart.split("\\s+");
        String messagePart = logSplit[1].trim();
        String timeStamp = splitNonMessagePart[0];
        String logLevel = splitNonMessagePart[1];
        return LogEntry.of(timeStamp, logLevel, messagePart);
    }

}
