package com.itera.intann.pamposql;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class ReviewDetails extends AppCompatActivity {
    ImageView dtImageView;
    TextView dtJudul, dtDeskripsi;
    Button btnRekomendasi;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_details);
        mContext = this;
        initcomponents();
        //ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(this).build();
        //ImageLoader.getInstance().init(config);

        dtImageView = (ImageView) findViewById(R.id.detail_gambar);
        dtJudul = (TextView) findViewById(R.id.detail_judul);
        dtDeskripsi = (TextView) findViewById(R.id.detail_deskripsi);
        dtImageView.setImageResource(getIntent().getIntExtra("detail_gambar",00));
        dtJudul.setText (getIntent().getStringExtra("detail_judul"));
        dtDeskripsi.setText (getIntent().getStringExtra("detail_deskripsi"));
    }

    private void initcomponents() {
        btnRekomendasi = (Button) findViewById(R.id.btnRekomendasi);

        btnRekomendasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, Rekomendasi.class));
            }
        });
    }



}
