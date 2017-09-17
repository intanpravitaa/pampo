package com.itera.intann.pamposql;

import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("rating_id")
    private int rating_id;
    @SerializedName("user_id")
    private int user_id;
    @SerializedName("item_id")
    private int item_id;
    @SerializedName("rating")
    private int rating;

    public Rating(int rating_id, int user_id, int item_id, int ratingValue) {
        this.rating_id = rating_id;
        this.user_id = user_id;
        this.item_id = item_id;
        this.rating = ratingValue;
    }

    //set

    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getRatingValue() {
        return rating;
    }

    public void setRatingValue(int ratingValue) {
        this.rating = ratingValue;
    }
}
