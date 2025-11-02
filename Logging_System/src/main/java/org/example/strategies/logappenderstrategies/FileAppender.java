package org.example.strategies.logappenderstrategies;

import org.example.models.LogRecord;
import org.example.strategies.formatterstrategies.ILogFormatterStrategy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements  IAppenderStrategy {
    private final ILogFormatterStrategy formatter;
    private final BufferedWriter writer;
    public FileAppender(ILogFormatterStrategy formatter){
        this.formatter = formatter;
        String filePath = "/home/chandra/Queries.txt"; // Example hardcoded path
        try {
            this.writer = new BufferedWriter(new FileWriter(filePath, true));
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize FileAppender", e);
        }
    }

    @Override
    public synchronized void append(LogRecord record) {
        // Get the file path from configuration (hardcoded here for simplicity)
       try{
           writer.append(formatter.format(record));
           writer.newLine();
           writer.flush();
       } catch (IOException e){
           throw new RuntimeException("Failed to append log record to file", e);
       }
    }

    @Override
    public void closeAppender() {
        try{
            writer.close();
        } catch (IOException e){
            throw new RuntimeException("Failed to close FileAppender", e);
        }
    }
}
