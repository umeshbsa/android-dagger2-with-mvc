package com.app.dagger2withmvc.listner;


import com.app.dagger2withmvc.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApiService {
    @GET(" http://services.hanselandpetal.com/feeds/flowers.json")
    Call<List<Flower>> getFlowersAPI();
}
