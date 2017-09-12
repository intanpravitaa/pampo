package com.itera.intann.pamposql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ReviewDetails extends AppCompatActivity {
    ImageView dtImageView;
    TextView dtJudul, dtDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_details);
        dtImageView = (ImageView) findViewById(R.id.detail_gambar);
        dtJudul = (TextView) findViewById(R.id.detail_judul);
        dtDeskripsi = (TextView) findViewById(R.id.detail_deskripsi);
        dtImageView.setImageResource(getIntent().getIntExtra("detail_gambar",00));
        dtJudul.setText (getIntent().getStringExtra("detail_judul"));
        dtDeskripsi.setText (getIntent().getStringExtra("detail_deskripsi"));
    }
}
