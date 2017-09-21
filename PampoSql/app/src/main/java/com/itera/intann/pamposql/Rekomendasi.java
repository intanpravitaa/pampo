package com.itera.intann.pamposql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.itera.intann.pamposql.apihelper.BaseApiService;
import com.itera.intann.pamposql.apihelper.UtilsApi;
import com.itera.intann.pamposql.model.ListUser;
import com.itera.intann.pamposql.model.Review;
import com.itera.intann.pamposql.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Rekomendasi extends AppCompatActivity {

    //RecyclerView recyclerView;
    int totalUser;
    Map <String,List<RatingTable>> simTable;
    Map<Integer,RatingTable> ratingTable;
    List<Rating> allReview;
    Map<String, Float> simResult;
    Map<String, Float> predictTable;
    Map<Integer, Integer> predictResult;
    TextView tvResultRekomendasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi);

        //recyclerView = (RecyclerView) findViewById(R.id.RecyclerRekomendasi);
        allReview = new ArrayList<>();
        simTable = new HashMap<String,List<RatingTable>>();
        simResult = new HashMap<String,Float>();
        predictTable = new HashMap<String, Float>();
        predictResult = new HashMap<Integer,Integer>();

        tvResultRekomendasi = (TextView)findViewById(R.id.rekomendasi);

        BaseApiService service = UtilsApi.getAPIService();

        Call<ListUser> callUser = service.getUser();
        callUser.enqueue(new Callback<ListUser>() {
            @Override
            public void onResponse(Call<ListUser> call, Response<ListUser> response) {
                try {
                    List<User> list = response.body().getUser();
                    totalUser = list.size();
                } catch (Exception e) {
                    Toast.makeText(Rekomendasi.this, "Error Rekomendasi!!!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ListUser> call, Throwable t) {
                Toast.makeText(Rekomendasi.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });

        Call<ListRating> call = service.getRating();
        call.enqueue(new Callback<ListRating>() {
            @Override
            public void onResponse(Call<ListRating> call, Response<ListRating> response) {
                try {
                    Toast.makeText(Rekomendasi.this, "Masuk Rekomendasi", Toast.LENGTH_SHORT).show();
                    System.out.println("====================");
                    System.out.println("Hasil Rating Table");
                    System.out.println("====================");
                    if (response.body().getRating() == null) {
                        Toast.makeText(Rekomendasi.this, "Rekomendasi kosong", Toast.LENGTH_SHORT).show();
                        System.out.println("Rekomendasi Kosong");
                    }else {
                        Toast.makeText(Rekomendasi.this, "Success !!", Toast.LENGTH_SHORT).show();
                        System.out.println("Rekomendasi Success");
                        List<Rating> list = response.body().getRating();
                        Rating rating = null;
                        for (int i = 0; i < list.size(); i++) {
                            int rating_id = list.get(i).getRating_id();
                            int user_id = list.get(i).getUser_id();
                            int item_id = list.get(i).getItem_id();
                            int ratingValue = list.get(i).getRatingValue();
                            rating = new Rating(rating_id, user_id, item_id, ratingValue);
                            allReview.add(rating);
                        }
                        createRatingTable();
                        Similarity();
                        Prediction();

                        List<Review> listReview = Global.getInstance().review;

                        System.out.println("User id adalah : "+ predictResult.get(Global.getInstance().userId));
                        for (int i = 0; i < listReview.size(); i++) {
                            if (listReview.get(i).getId_review() == predictResult.get(Global.getInstance().userId)){
                                String judul = listReview.get(i).getJudul_review();
                                tvResultRekomendasi.setText(judul);
                            }
                        }

                    }
                } catch (Exception e) {
                    Toast.makeText(Rekomendasi.this, "Error Rekomendasi!!!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ListRating> call, Throwable t) {
                Toast.makeText(Rekomendasi.this, "Tidak berhasil", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void createRatingTable(){
        ratingTable = new HashMap<Integer, RatingTable>();
        for(int i = 0;i<totalUser;i++){
            List<Integer> item = new ArrayList<Integer>();
            for(int j = 0; j<Global.getInstance().review.size();j++){
                //inisialisasi rating table dengan 0
                item.add(0);
            }
            //RatingTable tbl = new RatingTable(i,0,0,0,0,0,0);
            RatingTable tbl = new RatingTable(i,item);
            ratingTable.put(i, tbl);
        }

        for(Map.Entry<Integer,RatingTable> iter : ratingTable.entrySet()){
            List<Rating> list = allReview;
            for (int i = 0; i < list.size(); i++) {
                int rating_id = list.get(i).getRating_id();
                int user_id = list.get(i).getUser_id();
                int item_id = list.get(i).getItem_id();
                int ratingValue = list.get(i).getRatingValue();

                //kalau getUserId dari allReview = di ratingtable.userid, maka masuk ke perulangan
                if(user_id == iter.getValue().getUser_id()){
                    
                    for(int j = 0;j<iter.getValue().getItem().size();j++) {
                       //untuk  mengecek apakah item_id pada rating table = item_id. pada list allReview
                        if(j==item_id){
                            iter.getValue().getItem().set(j,ratingValue);// isi ratingTable dengan value yang ada di Allrinvew
                        }
                    }
                }
            }
            //System.out.println(iter.getValue().getUser_id()+"-"+iter.getValue().getItem1()+"-"+iter.getValue().getItem2()+"-"+iter.getValue().getItem3()+"-"+iter.getValue().getItem4()+"-"+iter.getValue().getItem5());
        }

        for(Map.Entry<Integer,RatingTable> iter : ratingTable.entrySet()) {
            //float avg = iter.getValue().getItem1() + iter.getValue().getItem2() + iter.getValue().getItem3() + iter.getValue().getItem4() + iter.getValue().getItem5();
            float avg = 0;
            for (int i = 0; i < iter.getValue().getItem().size(); i++) {
                avg += iter.getValue().getItem().get(i);
            }

            avg /= iter.getValue().getItem().size();
            iter.getValue().setAvg(avg);
            //System.out.println(iter.getValue().getUser_id()+"-"+iter.getValue().getItem1()+"-"+iter.getValue().getItem2()+"-"+iter.getValue().getItem3()+"-"+iter.getValue().getItem4()+"-"+iter.getValue().getItem5()+"-"+iter.getValue().getAvg());
            System.out.print(iter.getValue().getUser_id()+"-");
            for (int i = 0; i < iter.getValue().getItem().size(); i++) {
                System.out.print("-"+iter.getValue().getItem().get(i));
            }
            System.out.println("-"+iter.getValue().getAvg());
        }

    }

    public void Similarity () {
        List<RatingTable> tempTable = new ArrayList<RatingTable>(); //buat temporary table untuk menyimpan list of user yang ngerating

        for(int i = 0;i < (ratingTable.get(1).getItem().size()-1);i++){ //looping untuk ngecek user ngevote item 1, (-1) biar dia ga ngecek item yg sama
            for(int j = i+1;j < ratingTable.get(1).getItem().size();j++){// looping untuk mngecek user ngevote item 2
                String tblName = "m" + i + "m" + j; // buat key di tabel similarity
                List<RatingTable> list = new ArrayList<RatingTable>(); //buat table untuk menyimpan list of user yang ngerating
                for(Map.Entry<Integer,RatingTable> iter : ratingTable.entrySet()) { // untuk mengambil nilai rating dari ratingtable
                    if ((iter.getValue().getItem().get(i) != 0) && (iter.getValue().getItem().get(j) != 0)) {
                        list.add(iter.getValue()); //dimasukkin ke list
                    }
                }
                simTable.put(tblName,list); // list yg berisi user yg ngevote untuk tblName, lalu datanya disimpan di similarity table
            }
        }


        /*for check Similarity table
        for(Map.Entry<String,List<RatingTable>> iter : simTable.entrySet()){
            System.out.println("========="+iter.getKey()+"=========");
            for(int i = 0;i < iter.getValue().size();i++){
                System.out.print(iter.getValue().get(i).getUser_id());
                for(int j = 0;j < iter.getValue().get(i).getItem().size();j++){
                    System.out.print("-"+iter.getValue().get(i).getItem().get(j));
                }
                System.out.println("-"+iter.getValue().get(i).getAvg());
            }
            System.out.println();
        }*/



        for(Map.Entry<String,List<RatingTable>> iter : simTable.entrySet()) { //map of list ratingtable, isinya simtable (ngambil data)
            Float result;
            float resultPembilang = 0;
            float resultPenyebut1 = 0;
            float resultPenyebut2 = 0;
            float resultPenyebut = 0;

            for(int i = 0;i < iter.getValue().size();i++){ //ngambil data yg ada di list RatingTable
                for(int j = 0;j < iter.getValue().get(i).getItem().size();j++){
                    float a = iter.getValue().get(i).getItem().get(j)-iter.getValue().get(i).getAvg();
                    float b = iter.getValue().get(i).getItem().get(j)-iter.getValue().get(i).getAvg();
                    resultPembilang += a * b;
                    resultPenyebut1 += Math.sqrt(a*a);
                    resultPenyebut2 += Math.sqrt(b*b);
                }
            }

            resultPenyebut = resultPenyebut1 * resultPenyebut2;
            result = resultPembilang/resultPenyebut;

            if(result.isNaN()){ // Nan contoh : kalau dibagi 0, hasil infinte. infinite itu yg disebut dg nan
                simResult.put(iter.getKey(), (float) 0);
            }else{
                simResult.put(iter.getKey(),result);
            }

            //System.out.println("Result "+iter.getKey()+": "+simResult.get(iter.getKey()));
        }

        System.out.println("======== Similarity Table =========");

        for(Map.Entry<String,Float> iter : simResult.entrySet()) {
            System.out.println("Result "+iter.getKey()+": "+iter.getValue());
        }
    }

    public void Prediction(){

        System.out.println("======== Prediction Table =========");
        for(Map.Entry<Integer,RatingTable> iter : ratingTable.entrySet()) {
            //System.out.println(iter.getValue().getItem().size());
            for (int i = 0; i < iter.getValue().getItem().size(); i++) { // untuk ngecek kalau i belum dirating
                float resultPembilang = 0;
                float resultPenyebut = 0;
                Float result;
                String key;
                if (iter.getValue().getItem().get(i) == 0) {
                    for (int j = 0; j < iter.getValue().getItem().size(); j++) { // untuk memulai hitung dari 0
                        if (j != i) { // 1,1 tidak mungkin, 22 tidak mungkin, dst. kalau tidak gini nanti error null pointer

                            if(i<j){
                                key = "m" + i + "m" + j;
                            }else{
                                key = "m" + j + "m" + i;
                            }

                            //System.out.println(key);
                            resultPembilang += (iter.getValue().getItem().get(j) * simResult.get(key));
                            resultPenyebut += Math.abs(simResult.get(key));
                        }
                    }
                    System.out.print("User : "+iter.getValue().getUser_id());
                    System.out.print(", Item : "+i);
                    System.out.print(", pembilang : "+resultPembilang);
                    System.out.print(", penyebut : "+resultPenyebut);
                    result = resultPembilang / resultPenyebut;
                    if(result.isNaN()){
                        result = (float) 0;
                    }
                    System.out.println(", Predict rate : "+result);
                    if (iter.getValue().getUser_id() < 10) {
                        String user;
                        if(i!=10){
                            user = "u0" + iter.getValue().getUser_id() + "m0" + i;
                        }else{
                            user = "u0" + iter.getValue().getUser_id() + "m" + i;
                        }

                        predictTable.put(user, result);
                    } else {
                        String user;
                        if(i!=10){
                            user = "u" + iter.getValue().getUser_id() + "m0" + i;
                        }else{
                            user = "u" + iter.getValue().getUser_id() + "m" + i;
                        }
                        predictTable.put(user, result);
                    }
                }
            }
        }

        Map<Integer,Float> tempTable = new HashMap<Integer, Float>(); // buat tabel untuk menampung predict rate yang tinggi

        for (int i=0;i<totalUser;i++){ 
            tempTable.put(i,(float) 0); //inisialisasi tempt table dg = 0
            predictResult.put(i,0); // inisialisasi predict result dg = 0
        }

        System.out.println("======Predict Table======");
        for(Map.Entry<String,Float> iter : predictTable.entrySet()) { // ngambil data dari predict table

            int user = Integer.parseInt(iter.getKey().substring(1,3)); // ngambil user dari key
            int item = Integer.parseInt(iter.getKey().substring(4,6)); // ngambil item dari key
            System.out.println("User : "+user+", item: "+item+ ", predict rate : "+iter.getValue());

            if((iter.getValue() > tempTable.get(user))){ // membandingkan nilai value yg ada di temp table dg predicttabble
                tempTable.put(user,iter.getValue()); //kalau yg di predict table lebih besar, diletakkan di tempt table 
                predictResult.put(user,item); // predict result nyimpen item id dan user id
            }
        }

        System.out.println("======Final Recomendation======");
        for(Map.Entry<Integer,Integer> iter : predictResult.entrySet()) {
            System.out.println("User : "+iter.getKey()+", 1st item Recomendation: "+iter.getValue());
        }


    }

    public List<Rating> getAllReview() {
        return allReview;
    }

    public void setAllReview(List<Rating> allReview) {
        this.allReview = allReview;
    }

    public Map<String, Float> getSimResult() {
        return simResult;
    }

    public void setSimResult(Map<String, Float> simResult) {
        this.simResult = simResult;
    }

    public Map<Integer, Integer> getPredictResult() {
        return predictResult;
    }

    public void setPredictResult(Map<Integer, Integer> predictResult) {
        this.predictResult = predictResult;
    }

    public Map<Integer, RatingTable> getRatingTable() {
        return ratingTable;
    }

    public void setRatingTable(Map<Integer, RatingTable> ratingTable) {
        this.ratingTable = ratingTable;
    }


}

