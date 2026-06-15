package com.rm.lak;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LogEntry {
    private LocalDateTime time;
    private LogLevel level;
    private String message;

    public LogEntry(LocalDateTime time, LogLevel level, String message) {
        this.time = time;
        this.level = level;
        this.message = message;
    }

    public static LogEntry   of(String time,String level,String message){
       return new LogEntry(
             LocalDateTime.parse(time),
             LogLevel.valueOf(level),
             message
        );
    }
}
