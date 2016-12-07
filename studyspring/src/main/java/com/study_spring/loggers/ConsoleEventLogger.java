package com.study_spring.loggers;

import com.study_spring.EventLogger;

/**
 * Created by misha on 07.12.16.
 */
public class ConsoleEventLogger implements EventLogger {
    public  void logEvent(String ev){
        System.out.println(ev);
    }
}
