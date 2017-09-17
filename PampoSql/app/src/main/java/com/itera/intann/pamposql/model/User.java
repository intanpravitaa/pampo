package com.itera.intann.pamposql.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private int id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("email")
    private String email;

    public User(int id, String nama, String email) {
        this.id = id;
        this.nama = nama;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
