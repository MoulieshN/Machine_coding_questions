package org.example.strategies.logappenderstrategies;


import org.example.models.LogRecord;

public interface IAppenderStrategy {
    void append(LogRecord record);
    void closeAppender();
}
