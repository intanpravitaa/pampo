package com.itera.intann.pamposql.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListReview {

    @SerializedName("review")
    private List<Review> review;

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }


}
