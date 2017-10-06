package com.study_spring;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by misha on 07.12.16.
 */
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat dateFormat){
        this.date = date;
        this.df = dateFormat;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ id =");
        stringBuilder.append(id);
        stringBuilder.append(" , msg = ");
        stringBuilder.append(msg);
        stringBuilder.append(" , date");
        stringBuilder.append(df.format(date));
        return stringBuilder.toString();
    }
}
