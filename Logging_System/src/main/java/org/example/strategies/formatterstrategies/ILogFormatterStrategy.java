package org.example.strategies.formatterstrategies;

import org.example.models.LogRecord;

public interface ILogFormatterStrategy {
    String format(LogRecord record);
}
