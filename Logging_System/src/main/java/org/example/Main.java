package org.example;

import org.example.enums.LogLevel;
import org.example.strategies.formatterstrategies.ILogFormatterStrategy;
import org.example.strategies.formatterstrategies.JsonFormatter;
import org.example.strategies.formatterstrategies.PlainTextFormatter;
import org.example.strategies.logappenderstrategies.ConsoleAppender;
import org.example.strategies.logappenderstrategies.FileAppender;
import org.example.strategies.logappenderstrategies.IAppenderStrategy;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ILogFormatterStrategy jsonFormatter = new JsonFormatter();
        ILogFormatterStrategy plainTextFormatter = new PlainTextFormatter();

        IAppenderStrategy consoleJsonAppender = new ConsoleAppender(plainTextFormatter);
        IAppenderStrategy filePlainTextAppender = new FileAppender(jsonFormatter);

        Logger logger = Logger.getInstance(LogLevel.ERROR, plainTextFormatter, Arrays.asList(consoleJsonAppender, filePlainTextAppender));

        logger.info("This is an info message.");
        logger.debug("This is a debug message.");
        logger.error("This is an error message.");
        logger.warn("This is a warning message.");
        logger.fatal("This is a fatal message.");
        logger.debug("Another debug message.");
        logger.info("Another info message.");



    }
}