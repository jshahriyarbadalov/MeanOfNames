package com.shahriyar.meaningofname;

import com.shahriyar.meaningofname.model.Names;
import com.shahriyar.meaningofname.network.NamesIteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


class NamesPresenter {
    private NamesView view;
    private NamesIteractor iteractor;

    public NamesPresenter(NamesView view) {
        this.view = view;
        iteractor = new NamesIteractor();

    }

    public void request(String name) {
        iteractor.getNames(name).enqueue(new NamesCallBack(view));
    }

    private class NamesCallBack implements Callback<Names> {
        private NamesView view;

        public NamesCallBack(NamesView view) {
            this.view = view;
        }

        @Override
        public void onResponse(Call<Names> call, Response<Names> response) {
            if (response.isSuccessful()) {
                if(response.body().getResponse()!=null) {
                    view.setNames(response.body().getResponse().getName());
                    view.setMeaning(response.body().getResponse().getMeaning());
                    view.setGender(response.body().getResponse().getGender());
                }else{
                    view.showError("Bu ad tapılmadı!");
                }
            }
            else{
                view.showError("Məlumat yuklənmədi təkrar yoxlayın!");
            }
        }

        @Override
        public void onFailure(Call<Names> call, Throwable t) {
            view.showError("Server səhvi! Zəhmət olmasa internet bağlantını yoxlayın.");
        }
    }
}
