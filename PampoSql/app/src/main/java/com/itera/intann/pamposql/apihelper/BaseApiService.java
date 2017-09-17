package com.itera.intann.pamposql.apihelper;

import com.itera.intann.pamposql.ListRating;
import com.itera.intann.pamposql.Rating;
import com.itera.intann.pamposql.model.ListReview;
import com.itera.intann.pamposql.model.ListUser;
import com.itera.intann.pamposql.model.Review;

import java.util.List;
import java.util.StringTokenizer;

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

    @FormUrlEncoded
    @POST("Simpanrating.php")
    Call<ResponseBody> simpanRating (@Field("email") String email,
                                     @Field("item_id") String item_id,
                                     @Field("rating") String rating);

    @GET("include/Getdata.php")
    Call<ListReview> getReview();

    @GET("include/Getrating.php")
    Call<ListRating> getRating();

    @GET("include/Getuser.php")
    Call <ListUser> getUser();

}
