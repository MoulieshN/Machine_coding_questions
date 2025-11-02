package org.example.strategies.formatterstrategies;

import org.example.models.LogRecord;

public class PlainTextFormatter implements ILogFormatterStrategy {
    @Override
    public String format(LogRecord record) {
        return String.format("[%s] [%s] [%s]", record.timestamp(), record.level(), record.msg());
    }
}
