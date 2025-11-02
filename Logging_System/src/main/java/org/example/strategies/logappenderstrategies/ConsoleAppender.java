package org.example.strategies.logappenderstrategies;

import org.example.models.LogRecord;
import org.example.strategies.formatterstrategies.ILogFormatterStrategy;


public class ConsoleAppender implements  IAppenderStrategy {
    private final ILogFormatterStrategy formatter;

    public ConsoleAppender(ILogFormatterStrategy formatter) {
        this.formatter = formatter;
    }
    @Override
    public void append(LogRecord record) {
        System.out.println(formatter.format(record));
    }

    @Override
    public void closeAppender() {
        System.out.println("console appender closed");
    }


}
