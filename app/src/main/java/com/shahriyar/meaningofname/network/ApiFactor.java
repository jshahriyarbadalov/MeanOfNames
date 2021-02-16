package com.shahriyar.meaningofname.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.shahriyar.meaningofname.utils.Constant.BASE_URL;

public class ApiFactor {
    private static  ApiFactor apiFactory;
    private static Retrofit retrofit;

    private ApiFactor(){
        retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public static  ApiFactor getInstance(){
        if(apiFactory==null){
            apiFactory=new ApiFactor();
        }
        return apiFactory;
    }
    public ApiService getApiService(){
        return retrofit.create(ApiService.class);
    }
}
