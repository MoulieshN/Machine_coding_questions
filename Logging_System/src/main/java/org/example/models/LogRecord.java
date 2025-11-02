package org.example.models;

import org.example.enums.LogLevel;

import java.util.Date;

public record LogRecord(LogLevel level, String msg, Date timestamp) {
}
