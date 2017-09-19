package com.itera.intann.pamposql;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.itera.intann.pamposql.apihelper.BaseApiService;
import com.itera.intann.pamposql.apihelper.UtilsApi;
import com.itera.intann.pamposql.model.ListReview;
import com.itera.intann.pamposql.model.Review;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Dashboard extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Review> listing;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        listing = new ArrayList<>();
        mContext = this;

        BaseApiService service = UtilsApi.getAPIService();
        Call<ListReview> call = service.getReview();
        call.enqueue(new Callback<ListReview>() {
            @Override
            public void onResponse(Call<ListReview> call, Response<ListReview> response) {
                try {
                    if (response.body().getReview() == null) {
                        Toast.makeText(Dashboard.this, "List Null", Toast.LENGTH_SHORT).show();
                    } else {
                        List<Review> list = response.body().getReview();
                        Toast.makeText(Dashboard.this, "Success !!", Toast.LENGTH_SHORT).show();
                        Review review = null;
                        for (int i = 0; i < list.size(); i++) {
                            int id = list.get(i).getId_review();
                            String name = list.get(i).getJudul_review();
                            String image = list.get(i).getGambar_review();
                            String deskripsi = list.get(i).getDeskripsi_review();
                            String detailimage = list.get(i).getGambar_detail();
                            System.out.println(name);
                            System.out.println(image);
                            System.out.println(deskripsi);
                            review = new Review(id, name, image, deskripsi,detailimage);
                            listing.add(review);
                        }
                        Global.getInstance().review = listing;
                        Recycleradapter recyclerAdapter = new Recycleradapter(listing, ImageLoader.getInstance(), mContext);
                        RecyclerView.LayoutManager recycle = new GridLayoutManager(Dashboard.this, 2);
                        recyclerView.addItemDecoration(new GridSpacingdecoration(2, dpToPx(10), true));
                        recyclerView.setLayoutManager(recycle);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(recyclerAdapter);
                    }
                } catch (Exception e) {
                    Toast.makeText(Dashboard.this, "Error !!!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ListReview> call, Throwable t) {
                Toast.makeText (Dashboard.this,"Tidak berhasil", Toast.LENGTH_SHORT).show();
            }

        });


    }

    public class GridSpacingdecoration extends RecyclerView.ItemDecoration {

        private int span;
        private int space;
        private boolean include;

        public GridSpacingdecoration(int span, int space, boolean include) {
            this.span = span;
            this.space = space;
            this.include = include;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % span;

            if (include) {
                outRect.left = space - column * space / span;
                outRect.right = (column + 1) * space / span;

                if (position < span) {
                    outRect.top = space;
                }
                outRect.bottom = space;
            } else {
                outRect.left = column * space / span;
                outRect.right = space - (column + 1) * space / span;
                if (position >= span) {
                    outRect.top = space;
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}