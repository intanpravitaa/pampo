package com.itera.intann.pamposql.apihelper;

public class UtilsApi {
    // 127.0.0.1 adalah localhost.
    public static final String BASE_URL_API = "http://192.168.43.54/pampo/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
