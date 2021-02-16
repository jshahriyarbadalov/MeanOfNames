package com.shahriyar.meaningofname.network;

import com.shahriyar.meaningofname.model.Names;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
   @GET("MeaningOfName/{name}")
   Call<Names> getNames(@Path("name") String path);
}


