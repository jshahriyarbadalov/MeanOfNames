package com.shahriyar.meaningofname.network;

import com.shahriyar.meaningofname.model.Names;

import retrofit2.Call;

public class NamesIteractor {
    private ApiFactor apiFactor;

    public NamesIteractor() {
         apiFactor=ApiFactor.getInstance();
    }

    public Call<Names> getNames(String name){
        return apiFactor.getApiService().getNames(name);
    }
}
