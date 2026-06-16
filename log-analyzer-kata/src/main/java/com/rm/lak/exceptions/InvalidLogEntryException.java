package com.rm.lak.exceptions;

public class InvalidLogEntryException extends RuntimeException {

    public InvalidLogEntryException(String message) {
        super(message);
    }
}
