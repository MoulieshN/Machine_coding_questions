package org.example;

import com.sun.source.tree.SynchronizedTree;
import org.example.enums.LogLevel;
import org.example.models.LogRecord;
import org.example.strategies.formatterstrategies.ILogFormatterStrategy;
import org.example.strategies.logappenderstrategies.IAppenderStrategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {
    private static volatile  Logger instance;
    private LogLevel level;
    private ILogFormatterStrategy formatterStrategy;
    private List<IAppenderStrategy> appenderStrategies;
    private Logger(LogLevel level, ILogFormatterStrategy formatterStrategy, List<IAppenderStrategy> appenderStrategies) {
        this.level = level;
        this.formatterStrategy = formatterStrategy;
        this.appenderStrategies = new ArrayList<>(appenderStrategies);
    }

    public static Logger getInstance(LogLevel level, ILogFormatterStrategy formatterStrategy, List<IAppenderStrategy> appenderStrategies) {
        if(instance == null){
            synchronized(Logger.class){
                if(instance == null){
                    instance = new Logger(level, formatterStrategy, appenderStrategies);
                }
            }
        }
        return instance;
    }

    private void log(LogLevel lvl, String msg){
        Date now = new Date();
        synchronized (this){
            if(lvl.ordinal() >= this.level.ordinal()){
                LogRecord record = new LogRecord(lvl, msg, now);
                for(IAppenderStrategy appender : appenderStrategies){
                    appender.append(record);
                }
            }
        }
    }

    public void info(String msg){
        this.log(LogLevel.INFO, msg);
    }

    public void debug(String msg) {
        this.log(LogLevel.DEBUG, msg);
    }

    public void error(String msg) {
        this.log(LogLevel.ERROR, msg);
    }

    public void warn(String msg) {
        this.log(LogLevel.WARN, msg);
    }

    public void fatal(String msg) {
        this.log(LogLevel.FATAL, msg);
    }

    public void closeLogger(){
        for(IAppenderStrategy appender : appenderStrategies){
            appender.closeAppender();
        }
    }

    public void addAppender(IAppenderStrategy appender){
        this.appenderStrategies.add(appender);
    }

    public void removeAppender(IAppenderStrategy appender){
        this.appenderStrategies.remove(appender);
    }

    public void setLogLevel(LogLevel level){
        this.level = level;
    }

    public LogLevel getLogLevel(){
        return this.level;
    }

    public ILogFormatterStrategy getFormatterStrategy(){
        return this.formatterStrategy;
    }

    public void setFormatterStrategy(ILogFormatterStrategy formatterStrategy){
        this.formatterStrategy = formatterStrategy;
    }

    public List<IAppenderStrategy> getAppenderStrategies(){
        return this.appenderStrategies;
    }

    public void setAppenderStrategies(List<IAppenderStrategy> appenderStrategies){
        this.appenderStrategies = appenderStrategies;
    }

}
