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
    /*List<RatingTable> m1m2;
    List<RatingTable> m1m3;
    List<RatingTable> m1m4;
    List<RatingTable> m1m5;
    List<RatingTable> m2m3;
    List<RatingTable> m2m4;
    List<RatingTable> m2m5;
    List<RatingTable> m3m4;
    List<RatingTable> m3m5;
    List<RatingTable> m4m5;*/
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
        /*
        m1m2 = new ArrayList<>();
        m1m3 = new ArrayList<>();
        m1m4 = new ArrayList<>();
        m1m5 = new ArrayList<>();
        m2m3 = new ArrayList<>();
        m2m4 = new ArrayList<>();
        m2m5 = new ArrayList<>();
        m3m4 = new ArrayList<>();
        m3m5 = new ArrayList<>();
        m4m5 = new ArrayList<>();*/
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

                if(user_id == iter.getValue().getUser_id()){
                    for(int j = 0;j<iter.getValue().getItem().size();j++) {
                        if(j==item_id){
                            iter.getValue().getItem().set(j,ratingValue);
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
        List<RatingTable> tempTable = new ArrayList<RatingTable>();

        for(int i = 0;i < (ratingTable.get(1).getItem().size()-1);i++){
            for(int j = i+1;j < ratingTable.get(1).getItem().size();j++){
                String tblName = "m" + i + "m" + j;
                List<RatingTable> list = new ArrayList<RatingTable>();
                for(Map.Entry<Integer,RatingTable> iter : ratingTable.entrySet()) {
                    if ((iter.getValue().getItem().get(i) != 0) && (iter.getValue().getItem().get(j) != 0)) {
                        list.add(iter.getValue());
                    }
                }
                simTable.put(tblName,list);
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



        for(Map.Entry<String,List<RatingTable>> iter : simTable.entrySet()) {
            Float result;
            float resultPembilang = 0;
            float resultPenyebut1 = 0;
            float resultPenyebut2 = 0;
            float resultPenyebut = 0;

            for(int i = 0;i < iter.getValue().size();i++){
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

            if(result.isNaN()){
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
            for (int i = 0; i < iter.getValue().getItem().size(); i++) {
                float resultPembilang = 0;
                float resultPenyebut = 0;
                Float result;
                String key;
                if (iter.getValue().getItem().get(i) == 0) {
                    for (int j = 0; j < iter.getValue().getItem().size(); j++) {
                        if (j != i) {

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

        Map<Integer,Float> tempTable = new HashMap<Integer, Float>();

        for (int i=0;i<totalUser;i++){
            tempTable.put(i,(float) 0);
            predictResult.put(i,0);
        }

        System.out.println("======Predict Table======");
        for(Map.Entry<String,Float> iter : predictTable.entrySet()) {

            int user = Integer.parseInt(iter.getKey().substring(1,3));
            int item = Integer.parseInt(iter.getKey().substring(4,6));
            //System.out.println( iter.getKey()+" : "+iter.getValue());
            System.out.println("User : "+user+", item: "+item+ ", predict rate : "+iter.getValue());

            if((iter.getValue() > tempTable.get(user))/* && (iter.getValue() <= 1) &&(iter.getValue() >0 )*/){
                tempTable.put(user,iter.getValue());
                predictResult.put(user,item);
            }
        }

        System.out.println("======Final Recomendation======");
        for(Map.Entry<Integer,Integer> iter : predictResult.entrySet()) {
            System.out.println("User : "+iter.getKey()+", 1st item Recomendation: "+iter.getValue());
        }

            //System.out.println(iter.getValue().getUser_id()+"-"+iter.getValue().getItem1()+"-"+iter.getValue().getItem2()+"-"+iter.getValue().getItem3()+"-"+iter.getValue().getItem4()+"-"+iter.getValue().getItem5()+"-"+iter.getValue().getAvg());
            /*float result1 = 0;
            float result2 = 0;
            float result3 = 0;
            float result4 = 0;
            float result5 = 0;
            if(iter.getValue().getItem1() == 0 ){
                float a = iter.getValue().getItem2();
                float b = iter.getValue().getItem3();
                float c = iter.getValue().getItem4();
                float d = iter.getValue().getItem5();
                result1 += (a * simResult.get("m1m2")) + (b * simResult.get("m1m3")) + (c * simResult.get("m1m4")) + (d * simResult.get("m1m5"));
                result1 /= (Math.abs(simResult.get("m1m2") + simResult.get("m1m3") + simResult.get("m1m4") + simResult.get("m1m5")));
                if(iter.getValue().getUser_id() < 10){
                    String user = "u0"+iter.getValue().getUser_id()+"m1";
                    predictTable.put(user,result1);
                }else{
                    String user = "u"+iter.getValue().getUser_id()+"m1";
                    predictTable.put(user,result1);
                }
            }
            if(iter.getValue().getItem2() == 0){
                float a = iter.getValue().getItem1();
                float b = iter.getValue().getItem3();
                float c = iter.getValue().getItem4();
                float d = iter.getValue().getItem5();
                result2 += (a * simResult.get("m1m2")) + (b * simResult.get("m2m3")) + (c * simResult.get("m2m4")) + (d * simResult.get("m2m5"));
                result2 /= (Math.abs(simResult.get("m1m2") + simResult.get("m2m3") + simResult.get("m2m4") + simResult.get("m2m5")));
                if(iter.getValue().getUser_id() < 10){
                    String user = "u0"+iter.getValue().getUser_id()+"m2";
                    predictTable.put(user,result2);
                }else{
                    String user = "u"+iter.getValue().getUser_id()+"m2";
                    predictTable.put(user,result2);
                }
            }
            if(iter.getValue().getItem3() == 0){
                float a = iter.getValue().getItem1();
                float b = iter.getValue().getItem2();
                float c = iter.getValue().getItem4();
                float d = iter.getValue().getItem5();
                result3 += (a * simResult.get("m1m3")) + (b * simResult.get("m2m3")) + (c * simResult.get("m3m4")) + (d * simResult.get("m3m5"));
                result3 /= (Math.abs(simResult.get("m1m3") + simResult.get("m2m3") + simResult.get("m3m4") + simResult.get("m3m5")));
                if(iter.getValue().getUser_id() < 10){
                    String user = "u0"+iter.getValue().getUser_id()+"m3";
                    predictTable.put(user,result3);
                }else{
                    String user = "u"+iter.getValue().getUser_id()+"m3";
                    predictTable.put(user,result3);
                }
            }
            if(iter.getValue().getItem4() == 0){
                float a = iter.getValue().getItem1();
                float b = iter.getValue().getItem2();
                float c = iter.getValue().getItem3();
                float d = iter.getValue().getItem5();
                result4 += (a * simResult.get("m1m4")) + (b * simResult.get("m2m4")) + (c * simResult.get("m3m4")) + (d * simResult.get("m4m5"));
                result4 /= (Math.abs(simResult.get("m1m4") + simResult.get("m2m4") + simResult.get("m3m4") + simResult.get("m4m5")));
                if(iter.getValue().getUser_id() < 10){
                    String user = "u0"+iter.getValue().getUser_id()+"m4";
                    predictTable.put(user,result4);
                }else{
                    String user = "u"+iter.getValue().getUser_id()+"m4";
                    predictTable.put(user,result4);
                }
            }
            if(iter.getValue().getItem5() == 0){
                float a = iter.getValue().getItem1();
                float b = iter.getValue().getItem2();
                float c = iter.getValue().getItem3();
                float d = iter.getValue().getItem4();
                result5 += (a * simResult.get("m1m5")) + (b * simResult.get("m2m5")) + (c * simResult.get("m3m5")) + (d * simResult.get("m4m5"));
                result5 /= (Math.abs(simResult.get("m1m5") + simResult.get("m2m5") + simResult.get("m3m5") + simResult.get("m4m5")));
                if(iter.getValue().getUser_id() < 10){
                    String user = "u0"+iter.getValue().getUser_id()+"m5";
                    predictTable.put(user,result5);
                }else{
                    String user = "u"+iter.getValue().getUser_id()+"m5";
                    predictTable.put(user,result5);
                }
            }

        }
        Map<Integer,Float> tempTable = new HashMap<Integer, Float>();

        for (int i=0;i<totalUser;i++){
            tempTable.put(i,(float) 0);
            predictResult.put(i,0);
        }

        System.out.println("======Predict Table======");
        for(Map.Entry<String,Float> iter : predictTable.entrySet()) {

            int user = Integer.parseInt(iter.getKey().substring(1,3));
            int item = Integer.parseInt(iter.getKey().substring(4));
            System.out.println( iter.getKey()+" : "+iter.getValue());
            System.out.println("User : "+user+", item: "+item+ ", predict rate : "+iter.getValue());

            if((iter.getValue() > tempTable.get(user))/* && (iter.getValue() <= 1) &&(iter.getValue() >0 )*//*){
                tempTable.put(user,iter.getValue());
                predictResult.put(user,item);
            }
        }
        System.out.println("======Final Recomendation======");
        for(Map.Entry<Integer,Integer> iter : predictResult.entrySet()) {
            System.out.println("User : "+iter.getKey()+", 1st item Recomendation: "+iter.getValue());
        }

        /*for(Map.Entry<Integer,Integer> iter : predictResult.entrySet()) {
            System.out.println("User " + iter.getKey() + ", Rekomendasi item : "+ iter.getValue());
        }*/

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

