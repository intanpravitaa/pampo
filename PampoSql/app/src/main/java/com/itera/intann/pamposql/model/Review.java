package com.itera.intann.pamposql.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("id_review")
    private int id_review;
    @SerializedName("judul_review")
    private String judul_review;
    @SerializedName("gambar_review")
    private String gambar_review;
    @SerializedName("deskripsi_review")
    private String deskripsi_review;
    @SerializedName("gambar_detail")
    private String gambar_detail;

    public Review(int id, String name, String image, String deskripsi, String detailimage) {
        this.id_review = id;
        this.judul_review = name;
        this.gambar_review = image;
        this.deskripsi_review = deskripsi;
        this.gambar_detail = detailimage;
    }

    public int getId_review() {
        return id_review;
    }

    public void setId_review(int id_review) {
        this.id_review= id_review;
    }

    public String getJudul_review() {
        return judul_review;
    }

    public void setJudul_review(String judul_review) {
        this.judul_review = judul_review;
    }

    public String getGambar_review() {
        return gambar_review;
    }

    public void setGambar_review(String gambar_review) {
        this.gambar_review = gambar_review;
    }

    public String getDeskripsi_review() {
        return deskripsi_review;
    }

    public void setDeskripsi_review(String deskripsi_review) {
        this.deskripsi_review = deskripsi_review;
    }

    public String getGambar_detail() {
        return gambar_detail;
    }

    public void setGambar_detail(String gambar_detail) {
        this.gambar_detail = gambar_detail;
    }
}