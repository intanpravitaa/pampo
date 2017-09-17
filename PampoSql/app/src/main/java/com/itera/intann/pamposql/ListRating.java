package com.itera.intann.pamposql;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListRating {

    @SerializedName("rating")
    private List<Rating> rating;

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }
}
