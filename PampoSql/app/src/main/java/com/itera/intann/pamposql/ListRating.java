package com.itera.intann.pamposql;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by intann on 9/13/2017.
 */

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
