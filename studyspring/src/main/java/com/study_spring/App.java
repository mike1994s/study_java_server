package com.study_spring;

import com.study_spring.beans.Client;
import com.study_spring.loggers.ConsoleEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by misha on 07.12.16.
 */
public class App {
    public App(Client client, EventLogger evLoger){
        this.client = client;
        consoleEventLogger = evLoger;
    }
    private Client client;
    private EventLogger consoleEventLogger;
    public void logEvent(Event msg){
        consoleEventLogger.logEvent(msg);
    }
    public static void main(String argv[]){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        ;
        app.logEvent((Event)ctx.getBean("event"));
        app.logEvent((Event)ctx.getBean("event"));
    }
}
