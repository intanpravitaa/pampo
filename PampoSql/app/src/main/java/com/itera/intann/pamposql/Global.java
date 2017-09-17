package com.itera.intann.pamposql;

import com.itera.intann.pamposql.model.Review;

import java.util.List;

public class Global {

    public String userEmail;
    public List<Review> review;
    public int userId;

    private static Global instance = null;

    public static Global getInstance(){
        if(instance==null){
            instance = new Global();
        }
        return instance;
    }
}

