package com.db.task.dbclm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ApiError implements Serializable {
    private LocalDateTime timeStamp;
    private String message;
}
