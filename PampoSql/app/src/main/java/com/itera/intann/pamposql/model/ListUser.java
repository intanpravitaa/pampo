package com.itera.intann.pamposql.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListUser {

    @SerializedName("user")
    private List<User> user;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
