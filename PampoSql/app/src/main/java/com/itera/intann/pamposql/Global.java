package com.itera.intann.pamposql;

public class Global {

    public String userEmail;

    private static Global instance = null;

    public static Global getInstance(){
        if(instance==null){
            instance = new Global();
        }
        return instance;
    }
}

