package org.example.strategies.formatterstrategies;

import org.example.models.LogRecord;

public class JsonFormatter implements  ILogFormatterStrategy {
    @Override
    public String format(LogRecord record) {
        return String.format(
                "{\"timestamp\": \"%s\", \"level\": \"%s\", \"message\": \"%s\"}",
                record.timestamp(),
                record.level(),
                record.msg()
        );
    }
}
