package com.itera.intann.pamposql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.itera.intann.pamposql.apihelper.BaseApiService;
import com.itera.intann.pamposql.apihelper.UtilsApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Rekomendasi extends AppCompatActivity {

    RecyclerView recyclerView;
    List<RatingTable> m1m2;
    List<RatingTable> m1m3;
    List<RatingTable> m1m4;
    List<RatingTable> m1m5;
    List<RatingTable> m2m3;
    List<RatingTable> m2m4;
    List<RatingTable> m2m5;
    List<RatingTable> m3m4;
    List<RatingTable> m3m5;
    List<RatingTable> m4m5;
    Map<Integer,RatingTable> ratingTable;
    List<Rating> allReview;
    Map<String, Float> simResult;
    Map<String, Float> predictTable;
    Map<Integer, Integer> predictResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerRekomendasi);
        allReview = new ArrayList<>();
        m1m2 = new ArrayList<>();
        m1m3 = new ArrayList<>();
        m1m4 = new ArrayList<>();
        m1m5 = new ArrayList<>();
        m2m3 = new ArrayList<>();
        m2m4 = new ArrayList<>();
        m2m5 = new ArrayList<>();
        m3m4 = new ArrayList<>();
        m3m5 = new ArrayList<>();
        m4m5 = new ArrayList<>();
        simResult = new HashMap<String,Float>();
        predictTable = new HashMap<String, Float>();
        predictResult = new HashMap<Integer,Integer>();

        BaseApiService service = UtilsApi.getAPIService();
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
                            //System.out.println("Rating ID : "+rating_id+", User ID : "+user_id+", Item ID : "+item_id+", Rating Value : "+ratingValue);
                            rating = new Rating(rating_id, user_id, item_id, ratingValue);
                            allReview.add(rating);
                        }
                        createRatingTable();
                        Similarity();
                        Prediction();
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

    public List<RatingTable> getM1m2(){
        return m1m2;
    }

    public void setM1m2(List<RatingTable> m1m2) {
        this.m1m2 = m1m2;
    }

    public List<RatingTable> getM1m3() {
        return m1m3;
    }

    public void setM1m3(List<RatingTable> m1m3) {
        this.m1m3 = m1m3;
    }

    public List<RatingTable> getM1m4() {
        return m1m4;
    }

    public void setM1m4(List<RatingTable> m1m4) {
        this.m1m4 = m1m4;
    }

    public List<RatingTable> getM1m5() {
        return m1m5;
    }

    public void setM1m5(List<RatingTable> m1m5) {
        this.m1m5 = m1m5;
    }

    public List<RatingTable> getM2m3() {
        return m2m3;
    }

    public void setM2m3(List<RatingTable> m2m3) {
        this.m2m3 = m2m3;
    }

    public List<RatingTable> getM2m4() {
        return m2m4;
    }

    public void setM2m4(List<RatingTable> m2m4) {
        this.m2m4 = m2m4;
    }

    public List<RatingTable> getM2m5() {
        return m2m5;
    }

    public void setM2m5(List<RatingTable> m2m5) {
        this.m2m5 = m2m5;
    }

    public List<RatingTable> getM3m4() {
        return m3m4;
    }

    public void setM3m4(List<RatingTable> m3m4) {
        this.m3m4 = m3m4;
    }

    public List<RatingTable> getM3m5() {
        return m3m5;
    }

    public void setM3m5(List<RatingTable> m3m5) {
        this.m3m5 = m3m5;
    }

    public List<RatingTable> getM4m5() {
        return m4m5;
    }

    public void setM4m5(List<RatingTable> m4m5) {
        this.m4m5 = m4m5;
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

    public void createRatingTable(){
        ratingTable = new HashMap<Integer, RatingTable>();
        for(int i = 0;i<60;i++){
            RatingTable tbl = new RatingTable(i,0,0,0,0,0,0);
            ratingTable.put(i, tbl);
        }

       for(Map.Entry<Integer,RatingTable> iter : ratingTable.entrySet()){
            //System.out.println(iter.getUser_id()+"-"+iter.getItem1()+"-"+iter.getItem2()+"-"+iter.getItem3()+"-"+iter.getItem4()+"-"+iter.getItem5());
           List<Rating> list = allReview;
           for (int i = 0; i < list.size(); i++) {
               int rating_id = list.get(i).getRating_id();
               int user_id = list.get(i).getUser_id();
               int item_id = list.get(i).getItem_id();
               int ratingValue = list.get(i).getRatingValue();

               if(user_id == iter.getValue().getUser_id()){
                   if(item_id == 1){
                       iter.getValue().setItem1(ratingValue);
                   }else if(item_id == 2){
                       iter.getValue().setItem2(ratingValue);
                   }else if(item_id == 3){
                       iter.getValue().setItem3(ratingValue);
                   }else if(item_id == 4){
                       iter.getValue().setItem4(ratingValue);
                   }else if(item_id == 5){
                       iter.getValue().setItem5(ratingValue);
                   }
               }
           }
           //System.out.println(iter.getValue().getUser_id()+"-"+iter.getValue().getItem1()+"-"+iter.getValue().getItem2()+"-"+iter.getValue().getItem3()+"-"+iter.getValue().getItem4()+"-"+iter.getValue().getItem5());
       }

        for(Map.Entry<Integer,RatingTable> iter : ratingTable.entrySet()){
            float avg = iter.getValue().getItem1() + iter.getValue().getItem2() + iter.getValue().getItem3() + iter.getValue().getItem4() + iter.getValue().getItem5();
            avg /= 5;
            iter.getValue().setAvg(avg);
            System.out.println(iter.getValue().getUser_id()+"-"+iter.getValue().getItem1()+"-"+iter.getValue().getItem2()+"-"+iter.getValue().getItem3()+"-"+iter.getValue().getItem4()+"-"+iter.getValue().getItem5()+"-"+iter.getValue().getAvg());
        }

        //Similarity();
    }

    /*public void createRatingTable2(){
        for(Rating r: this.allReview){
            int usr = r.setUser_id();
            for(Rating u: this.allReview){
                if(usr==u.getUser_id()){

                }
            }
        }
    }*/

    public void Similarity () {
        for(Map.Entry<Integer,RatingTable> iter : ratingTable.entrySet()){
            if((iter.getValue().getItem1() != 0)&& (iter.getValue().getItem2() !=0)){
                m1m2.add(iter.getValue());
            }
            if((iter.getValue().getItem1() != 0)&& (iter.getValue().getItem3() !=0)){
                m1m3.add(iter.getValue());
            }
            if((iter.getValue().getItem1() != 0)&& (iter.getValue().getItem4() !=0)){
                m1m4.add(iter.getValue());
            }
            if((iter.getValue().getItem1() != 0)&& (iter.getValue().getItem5() !=0)){
                m1m5.add(iter.getValue());
            }
            if((iter.getValue().getItem2() != 0)&& (iter.getValue().getItem3() !=0)){
                m2m3.add(iter.getValue());
            }
            if((iter.getValue().getItem2() != 0)&& (iter.getValue().getItem4() !=0)){
                m2m4.add(iter.getValue());
            }
            if((iter.getValue().getItem2() != 0)&& (iter.getValue().getItem5() !=0)){
                m2m5.add(iter.getValue());
            }
            if((iter.getValue().getItem3() != 0)&& (iter.getValue().getItem4() !=0)){
                m3m4.add(iter.getValue());
            }
            if((iter.getValue().getItem3() != 0)&& (iter.getValue().getItem5() !=0)){
                m3m5.add(iter.getValue());
            }
            if((iter.getValue().getItem4() != 0)&& (iter.getValue().getItem5() !=0)){
                m4m5.add(iter.getValue());
            }
        }

        List<RatingTable> list = m1m2;
        List<RatingTable> list2 = m1m3;
        List<RatingTable> list3 = m1m4;
        List<RatingTable> list4 = m1m5;
        List<RatingTable> list5 = m2m3;
        List<RatingTable> list6 = m2m4;
        List<RatingTable> list7 = m2m5;
        List<RatingTable> list8 = m3m4;
        List<RatingTable> list9 = m3m5;
        List<RatingTable> list10 = m4m5;
        float result = 0;
        float resultPembilang = 0;
        float resultPenyebut1 = 0;
        float resultPenyebut2 = 0;
        float resultPenyebut = 0;

        System.out.println("==========M1M2==========");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Id user : "+list.get(i).getUser_id()+", M1 : "+list.get(i).getItem1()+", M2 : "+list.get(i).getItem2());
            float a = list.get(i).getItem1()-list.get(i).getAvg();
            float b = list.get(i).getItem2()-list.get(i).getAvg();
            resultPembilang += a * b;
            resultPenyebut1 += Math.sqrt(a*a);
            resultPenyebut2 += Math.sqrt(b*b);

        }
        resultPenyebut = resultPenyebut1 * resultPenyebut2;
        result = resultPembilang/resultPenyebut;
        simResult.put("m1m2",result);
        System.out.println("Result Pembilang : "+resultPembilang);
        System.out.println("Result Penyebut 1 : "+resultPenyebut1);
        System.out.println("Result Penyebut 2 : "+resultPenyebut2);
        System.out.println("Result M1M2 : "+simResult.get("m1m2"));

        result = 0;
        resultPembilang = 0;
        resultPenyebut1 = 0;
        resultPenyebut2 = 0;
        resultPenyebut = 0;
        System.out.println("==========M1M3==========");
        for (int i = 0; i < list2.size(); i++) {
            System.out.println("Id user : "+list2.get(i).getUser_id()+", M1 : "+list2.get(i).getItem1()+", M3 : "+list2.get(i).getItem3());
            float a = list2.get(i).getItem1()-list2.get(i).getAvg();
            float b = list2.get(i).getItem3()-list2.get(i).getAvg();
            resultPembilang += a * b;
            resultPenyebut1 += Math.sqrt(a*a);
            resultPenyebut2 += Math.sqrt(b*b);
        }
        resultPenyebut = resultPenyebut1 * resultPenyebut2;
        result = resultPembilang/resultPenyebut;
        simResult.put("m1m3",result);
        System.out.println("Result Pembilang : "+resultPembilang);
        System.out.println("Result Penyebut 1 : "+resultPenyebut1);
        System.out.println("Result Penyebut 2 : "+resultPenyebut2);
        System.out.println("Result M1M3 : "+simResult.get("m1m3"));

        result = 0;
        resultPembilang = 0;
        resultPenyebut1 = 0;
        resultPenyebut2 = 0;
        resultPenyebut = 0;
        System.out.println("==========M1M4==========");
        for (int i = 0; i < list3.size(); i++) {
            System.out.println("Id user : "+list3.get(i).getUser_id()+", M1 : "+list3.get(i).getItem1()+", M4 : "+list3.get(i).getItem4());
            float a = list3.get(i).getItem1()-list3.get(i).getAvg();
            float b = list3.get(i).getItem4()-list3.get(i).getAvg();
            resultPembilang += a * b;
            resultPenyebut1 += Math.sqrt(a*a);
            resultPenyebut2 += Math.sqrt(b*b);
        }
        resultPenyebut = resultPenyebut1 * resultPenyebut2;
        result = resultPembilang/resultPenyebut;
        simResult.put("m1m4",result);
        System.out.println("Result Pembilang : "+resultPembilang);
        System.out.println("Result Penyebut 1 : "+resultPenyebut1);
        System.out.println("Result Penyebut 2 : "+resultPenyebut2);
        System.out.println("Result M1M4 : "+simResult.get("m1m4"));

        result = 0;
        resultPembilang = 0;
        resultPenyebut1 = 0;
        resultPenyebut2 = 0;
        resultPenyebut = 0;
        System.out.println("==========M1M5==========");
        for (int i = 0; i < list4.size(); i++) {
            System.out.println("Id user : "+list4.get(i).getUser_id()+", M1 : "+list4.get(i).getItem1()+", M5 : "+list4.get(i).getItem5());
            float a = list4.get(i).getItem1()-list4.get(i).getAvg();
            float b = list4.get(i).getItem5()-list4.get(i).getAvg();
            resultPembilang += a * b;
            resultPenyebut1 += Math.sqrt(a*a);
            resultPenyebut2 += Math.sqrt(b*b);
        }
        resultPenyebut = resultPenyebut1 * resultPenyebut2;
        result = resultPembilang/resultPenyebut;
        simResult.put("m1m5",result);
        System.out.println("Result Pembilang : "+resultPembilang);
        System.out.println("Result Penyebut 1 : "+resultPenyebut1);
        System.out.println("Result Penyebut 2 : "+resultPenyebut2);
        System.out.println("Result M1M5 : "+simResult.get("m1m5"));

        result = 0;
        resultPembilang = 0;
        resultPenyebut1 = 0;
        resultPenyebut2 = 0;
        resultPenyebut = 0;
        System.out.println("==========M2M3==========");
        for (int i = 0; i < list5.size(); i++) {
            System.out.println("Id user : "+list5.get(i).getUser_id()+", M2 : "+list5.get(i).getItem2()+", M3 : "+list5.get(i).getItem3());
            float a = list5.get(i).getItem2()-list5.get(i).getAvg();
            float b = list5.get(i).getItem3()-list5.get(i).getAvg();
            resultPembilang += a * b;
            resultPenyebut1 += Math.sqrt(a*a);
            resultPenyebut2 += Math.sqrt(b*b);
        }

        resultPenyebut = resultPenyebut1 * resultPenyebut2;
        result = resultPembilang/resultPenyebut;
        simResult.put("m2m3",result);
        System.out.println("Result Pembilang : "+resultPembilang);
        System.out.println("Result Penyebut 1 : "+resultPenyebut1);
        System.out.println("Result Penyebut 2 : "+resultPenyebut2);
        System.out.println("Result M2M3 : "+simResult.get("m2m3"));

        result = 0;
        resultPembilang = 0;
        resultPenyebut1 = 0;
        resultPenyebut2 = 0;
        resultPenyebut = 0;
        System.out.println("==========M2M4==========");
        for (int i = 0; i < list6.size(); i++) {
            System.out.println("Id user : "+list6.get(i).getUser_id()+", M2 : "+list6.get(i).getItem2()+", M4 : "+list6.get(i).getItem4());
            float a = list6.get(i).getItem2()-list6.get(i).getAvg();
            float b = list6.get(i).getItem4()-list6.get(i).getAvg();
            resultPembilang += a * b;
            resultPenyebut1 += Math.sqrt(a*a);
            resultPenyebut2 += Math.sqrt(b*b);

        }
        resultPenyebut = resultPenyebut1 * resultPenyebut2;
        result = resultPembilang/resultPenyebut;
        simResult.put("m2m4",result);
        System.out.println("Result Pembilang : "+resultPembilang);
        System.out.println("Result Penyebut 1 : "+resultPenyebut1);
        System.out.println("Result Penyebut 2 : "+resultPenyebut2);
        System.out.println("Result M2M4 : "+simResult.get("m2m4"));

        result = 0;
        resultPembilang = 0;
        resultPenyebut1 = 0;
        resultPenyebut2 = 0;
        resultPenyebut = 0;
        System.out.println("==========M2M5==========");
        for (int i = 0; i < list7.size(); i++) {
            System.out.println("Id user : "+list7.get(i).getUser_id()+", M2 : "+list7.get(i).getItem2()+", M5 : "+list7.get(i).getItem5());
            float a = list7.get(i).getItem2()-list7.get(i).getAvg();
            float b = list7.get(i).getItem5()-list7.get(i).getAvg();
            resultPembilang += a * b;
            resultPenyebut1 += Math.sqrt(a*a);
            resultPenyebut2 += Math.sqrt(b*b);
        }
        resultPenyebut = resultPenyebut1 * resultPenyebut2;
        result = resultPembilang/resultPenyebut;
        simResult.put("m2m5",result);
        System.out.println("Result Pembilang : "+resultPembilang);
        System.out.println("Result Penyebut 1 : "+resultPenyebut1);
        System.out.println("Result Penyebut 2 : "+resultPenyebut2);
        System.out.println("Result M2M5 : "+simResult.get("m2m5"));

        result = 0;
        resultPembilang = 0;
        resultPenyebut1 = 0;
        resultPenyebut2 = 0;
        resultPenyebut = 0;
        System.out.println("==========M3M4==========");
        for (int i = 0; i < list8.size(); i++) {
            System.out.println("Id user : "+list8.get(i).getUser_id()+", M3 : "+list8.get(i).getItem3()+", M4 : "+list8.get(i).getItem4());
            float a = list8.get(i).getItem3()-list8.get(i).getAvg();
            float b = list8.get(i).getItem4()-list8.get(i).getAvg();
            resultPembilang += a * b;
            resultPenyebut1 += Math.sqrt(a*a);
            resultPenyebut2 += Math.sqrt(b*b);
        }
        resultPenyebut = resultPenyebut1 * resultPenyebut2;
        result = resultPembilang/resultPenyebut;
        simResult.put("m3m4",result);
        System.out.println("Result Pembilang : "+resultPembilang);
        System.out.println("Result Penyebut 1 : "+resultPenyebut1);
        System.out.println("Result Penyebut 2 : "+resultPenyebut2);
        System.out.println("Result M3M4 : "+simResult.get("m3m4"));

        result = 0;
        resultPembilang = 0;
        resultPenyebut1 = 0;
        resultPenyebut2 = 0;
        resultPenyebut = 0;
        System.out.println("==========M3M5==========");
        for (int i = 0; i < list9.size(); i++) {
            System.out.println("Id user : "+list9.get(i).getUser_id()+", M3 : "+list9.get(i).getItem3()+", M5 : "+list9.get(i).getItem5());
            float a = list9.get(i).getItem3()-list9.get(i).getAvg();
            float b = list9.get(i).getItem5()-list9.get(i).getAvg();
            resultPembilang += a * b;
            resultPenyebut1 += Math.sqrt(a*a);
            resultPenyebut2 += Math.sqrt(b*b);
        }
        resultPenyebut = resultPenyebut1 * resultPenyebut2;
        result = resultPembilang/resultPenyebut;
        simResult.put("m3m5",result);
        System.out.println("Result Pembilang : "+resultPembilang);
        System.out.println("Result Penyebut 1 : "+resultPenyebut1);
        System.out.println("Result Penyebut 2 : "+resultPenyebut2);
        System.out.println("Result M3M5 : "+simResult.get("m3m5"));

        result = 0;
        resultPembilang = 0;
        resultPenyebut1 = 0;
        resultPenyebut2 = 0;
        resultPenyebut = 0;
        System.out.println("==========M4M5==========");
        for (int i = 0; i < list10.size(); i++) {
            System.out.println("Id user : "+list10.get(i).getUser_id()+", M4 : "+list10.get(i).getItem4()+", M5 : "+list10.get(i).getItem5());
            float a = list10.get(i).getItem4()-list10.get(i).getAvg();
            float b = list10.get(i).getItem5()-list10.get(i).getAvg();
            resultPembilang += a * b;
            resultPenyebut1 += Math.sqrt(a*a);
            resultPenyebut2 += Math.sqrt(b*b);
        }
        resultPenyebut = resultPenyebut1 * resultPenyebut2;
        result = resultPembilang/resultPenyebut;
        simResult.put("m4m5",result);
        System.out.println("Result Pembilang : "+resultPembilang);
        System.out.println("Result Penyebut 1 : "+resultPenyebut1);
        System.out.println("Result Penyebut 2 : "+resultPenyebut2);
        System.out.println("Result M4M5 : "+simResult.get("m4m5"));

    }

    public void Prediction(){
        for(Map.Entry<Integer,RatingTable> iter : ratingTable.entrySet()){
            //System.out.println(iter.getValue().getUser_id()+"-"+iter.getValue().getItem1()+"-"+iter.getValue().getItem2()+"-"+iter.getValue().getItem3()+"-"+iter.getValue().getItem4()+"-"+iter.getValue().getItem5()+"-"+iter.getValue().getAvg());
            float result1 = 0;
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

            /*if(((result1 > result2) && (result1 > result3) && (result1 > result4) && (result1 > result5)) && (result1 > 0) && (result1 <1)){
                predictResult.put(iter.getValue().getUser_id(),1);
            }
            else if(((result2 > result1) && (result2 > result3) && (result2 > result4) && (result2 > result5)) && (result2 > 0) && (result2 <1)){
                predictResult.put(iter.getValue().getUser_id(),2);
            }
            else if(((result3 > result1) && (result3 > result2) && (result3 > result4) && (result3 > result5))&& (result3 > 0) && (result3 <1)){
                predictResult.put(iter.getValue().getUser_id(),3);
            }
            else if(((result4 > result1) && (result4 > result2) && (result4 > result3) && (result4 > result5)) && (result4 > 0) && (result4 <1)){
                predictResult.put(iter.getValue().getUser_id(),4);
            }
            else if(((result5 > result1) && (result5 > result2) && (result5 > result3) && (result5 > result4))&& (result5 > 0) && (result5 <1)){
                predictResult.put(iter.getValue().getUser_id(),5);
            }*/
        }
        Map<Integer,Float> tempTable = new HashMap<Integer, Float>();

        for (int i=0;i<60;i++){
            tempTable.put(i,(float) 0);
            predictResult.put(i,0);
        }

        System.out.println("======Predict Table======");
        for(Map.Entry<String,Float> iter : predictTable.entrySet()) {

            int user = Integer.parseInt(iter.getKey().substring(1,3));
            int item = Integer.parseInt(iter.getKey().substring(4));
            System.out.println( iter.getKey()+" : "+iter.getValue());
            System.out.println("User : "+user+", item: "+item+ ", predict rate : "+iter.getValue());

            if((iter.getValue() > tempTable.get(user)) && (iter.getValue() <= 1) &&(iter.getValue() >0 )){
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
}

