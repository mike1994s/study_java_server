package com.study_spring.beans;

/**
 * Created by misha on 07.12.16.
 */
public class Client {
    private String id;
    private String name;
    public Client(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
}
