package com.itera.intann.pamposql;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RatingTable {
    @SerializedName("user_id")
    private int user_id;
    private List<Integer> item;
    /*@SerializedName("item1")
    private int item1;
    @SerializedName("item2")
    private int item2;
    @SerializedName("item3")
    private int item3;
    @SerializedName("item4")
    private int item4;
    @SerializedName("item5")
    private int item5;
    */
    @SerializedName("avg")
    private float avg;

    /*public RatingTable(int user_id, int item1, int item2, int item3, int item4, int item5, float avg) {
        this.user_id = user_id;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.avg = avg;
    }*/

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

    /*public int getItem1() {
        return item1;
    }

    public void setItem1(int item1) {
        this.item1 = item1;
    }

    public int getItem2() {
        return item2;
    }

    public void setItem2(int item2) {
        this.item2 = item2;
    }

    public int getItem3() {
        return item3;
    }

    public void setItem3(int item3) {
        this.item3 = item3;
    }

    public int getItem4() {
        return item4;
    }

    public void setItem4(int item4) {
        this.item4 = item4;
    }

    public int getItem5() {
        return item5;
    }

    public void setItem5(int item5) {
        this.item5 = item5;
    }

    public float getAvg() {
        return avg;
    }
    */

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
