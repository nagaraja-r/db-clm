package com.db.task.dbclm.exception;

public class NaceDataNotFoundException extends Exception {

    public NaceDataNotFoundException(String message) {
        super(message);
    }

    public NaceDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NaceDataNotFoundException(Throwable cause) {
        super(cause);
    }
}
