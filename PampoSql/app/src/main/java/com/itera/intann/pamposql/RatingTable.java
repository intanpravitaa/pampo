package com.itera.intann.pamposql;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RatingTable {
    @SerializedName("user_id")
    private int user_id;
    private List<Integer> item;
    @SerializedName("avg")
    private float avg;

    public RatingTable(int user_id,List<Integer> item){
        this.user_id = user_id;
        this.item = item;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<Integer> getItem() {
        return item;
    }

    public void setItem(List<Integer> item) {
        this.item = item;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public float getAvg() {
        return avg;
    }
}
