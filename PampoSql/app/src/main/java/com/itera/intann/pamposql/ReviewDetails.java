package com.itera.intann.pamposql;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.itera.intann.pamposql.apihelper.BaseApiService;
import com.itera.intann.pamposql.apihelper.UtilsApi;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewDetails extends AppCompatActivity {
    ImageView dtImageView;
    TextView dtJudul, dtDeskripsi;
    Integer dtId;
    Button btnRekomendasi;
    Context mContext;
    RatingBar btnRating;
    BaseApiService mApiService;
    String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_details);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        //initcomponents();

        //private void initcomponents() {
        dtImageView = (ImageView) findViewById(R.id.detail_gambar);
        dtJudul = (TextView) findViewById(R.id.detail_judul);
        dtDeskripsi = (TextView) findViewById(R.id.detail_deskripsi);
        dtId = getIntent().getIntExtra("detail_id",00);
        userEmail = Global.getInstance().userEmail;
//       dtImageView.setImageResource(getIntent().getIntExtra("detail_gambar", 00));
        ImageLoader.getInstance().displayImage(getIntent().getStringExtra("detail_gambar"),dtImageView);
//        System.out.println(getIntent().getStringExtra("detail_gambar"));
        dtJudul.setText(getIntent().getStringExtra("detail_judul"));
        dtDeskripsi.setText(getIntent().getStringExtra("detail_deskripsi"));
        btnRating = (RatingBar) findViewById(R.id.ratingbar_rekomendasi);
        btnRekomendasi = (Button) findViewById(R.id.btnRekomendasi);

        btnRekomendasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReviewDetails.this, String.valueOf(btnRating.getRating()),
                        Toast.LENGTH_SHORT).show();
                //System.out.println("Rating value String : "+String.valueOf(btnRating.getRating()));

                simpanRating ();
                //startActivity(new Intent(mContext, Rekomendasi.class));
            }
        });
    }

    private void simpanRating() {

        String ratingValue = String.valueOf(btnRating.getRating());
        System.out.println("User Email : "+userEmail);
        System.out.println("Item Id : "+dtId.toString());
        System.out.println("Rating Value : "+ratingValue);
        mApiService.simpanRating(userEmail,
                dtId.toString(), ratingValue)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Log.i("debug", "onResponse: BERHASIL");
                            //loading.setVisibility(View.GONE);
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("error").equals("false")){
                                    Toast.makeText(mContext, "BERHASIL RATING", Toast.LENGTH_SHORT).show();
                                    System.out.println("Simpan rating berhasil");
                                    startActivity(new Intent(mContext, Rekomendasi.class));
                                } else {
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                    System.out.println("Simpan rating gagal");
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                System.out.println("Simpan rating tidak berhasil 1");
                            } catch (IOException e) {
                                e.printStackTrace();
                                System.out.println("Simpan rating tidak berhasil 2");
                            }
                        } else {
                            Log.i("debug", "onResponse: TIDAK BERHASIL");
                            System.out.println("Simpan rating tidak berhasil 3");
                            //loading.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
