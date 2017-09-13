package com.itera.intann.pamposql;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itera.intann.pamposql.model.Review;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Recycleradapter extends RecyclerView.Adapter<Recycleradapter.MyHolder>{


    List<Review> list;
    ImageLoader imageLoader;
    Context ctx;

    public Recycleradapter(List<Review> listData, ImageLoader imageLoader, Context ctx) {
        this.list = listData;
        this.imageLoader = imageLoader;
        this.ctx = ctx;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        MyHolder myHolder = new MyHolder(view,ctx, list);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Review review = list.get(position);
        holder.name.setText(review.getJudul_review());
        String image1 = "http://192.168.1.13/Pampo/gambar_review/"+review.getGambar_review();
        imageLoader.displayImage(image1, holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView name;
        ImageView image;
        List<Review> list = new ArrayList<Review>();
        Context ctx;

        public MyHolder(View itemView, Context ctx,  List<Review> list) {

            super(itemView);
            this.list = list;
            this.ctx = ctx;
            itemView.setOnClickListener(this);

            name = (TextView) itemView.findViewById(R.id.judul_review);
            image= (ImageView) itemView.findViewById(R.id.gambar_review);
        }

        @Override
        public void onClick(View view) {
            //ImageView detail_gambar = (ImageView) itemView.findViewById(R.id.detail_gambar);
            int position = getAdapterPosition();
            Review reviewsarapan = this.list.get(position);

            Intent intent = new Intent(ctx, ReviewDetails.class);
            intent.putExtra("detail_id", reviewsarapan.getJudul_review());
            intent.putExtra("detail_gambar", "http://192.168.1.13/Pampo/gambar_review/"+reviewsarapan.getGambar_review());
           // String image1 = "http://192.168.1.10/Pampo/gambar_review/"+reviewsarapan.getGambar_review();
           // imageLoader.displayImage(image1, detail_gambar);
            intent.putExtra("detail_judul", reviewsarapan.getJudul_review());
            intent.putExtra("detail_deskripsi", reviewsarapan.getDeskripsi_review());
            this.ctx.startActivity(intent);
        }
    }

}