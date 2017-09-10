package com.itera.intann.pamposql.apihelper;

import com.itera.intann.pamposql.model.ListReview;
import com.itera.intann.pamposql.model.Review;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {

    // Fungsi ini untuk memanggil API http://localhost/Pampo/login.php
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("email") String email,
                                    @Field("password") String password);

    // Fungsi ini untuk memanggil API http://localhost/Pampo/register.php
    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("nama") String nama,
                                       @Field("email") String email,
                                       @Field("password") String password);


    @GET("include/Getdata.php")
    Call<ListReview> getReview();
}
