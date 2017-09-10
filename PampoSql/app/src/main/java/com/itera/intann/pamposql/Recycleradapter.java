package com.itera.intann.pamposql;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itera.intann.pamposql.model.Review;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class Recycleradapter extends RecyclerView.Adapter<Recycleradapter.MyHolder>{


    List<Review> list;
    ImageLoader imageLoader;

    public Recycleradapter(List<Review> listData, ImageLoader imageLoader) {
        this.list =  listData;
        this.imageLoader= imageLoader;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Review review = list.get(position);
        holder.name.setText(review.getJudul_review());
        String image1 = review.getGambar_review();
        imageLoader.displayImage(image1, holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;

        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.judul_review);
            image= (ImageView) itemView.findViewById(R.id.gambar_review);
        }
    }

}