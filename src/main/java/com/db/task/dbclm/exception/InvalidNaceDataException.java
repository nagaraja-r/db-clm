package com.db.task.dbclm.exception;

import com.db.task.dbclm.util.ValidationRules;

import java.util.Optional;

public class InvalidNaceDataException extends RuntimeException {

    public InvalidNaceDataException(String message) {
        super(message);
    }

    private static InvalidNaceDataException create(String message) {
        throw new InvalidNaceDataException(message);
    }

    public static void throwIf(boolean errorCase, Optional<ValidationRules> rule) {
        if (errorCase) {
            create(rule.get().toString());
        }
    }
}
