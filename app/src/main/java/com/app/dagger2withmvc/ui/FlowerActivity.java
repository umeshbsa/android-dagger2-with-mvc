package com.app.dagger2withmvc.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.app.dagger2withmvc.R;
import com.app.dagger2withmvc.adapter.FlowerImageAdapter;
import com.app.dagger2withmvc.di.component.AppComponent;
import com.app.dagger2withmvc.listner.IApiService;
import com.app.dagger2withmvc.model.Flower;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * FlowerActivity : Used to show all flower list with adapter
 * */
public class FlowerActivity extends BaseActivity {

    /*
     * Inject to get instance of IApiService from NetModule
     * */
    @Inject
    IApiService request;
    private RecyclerView recycleViewFlower;

    /*
     * Set to this activity with AppComponent
     * */
    @Override
    public void injectAppComponent(AppComponent appComponent) {
        appComponent.plus(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleViewFlower = (RecyclerView) findViewById(R.id.recycle_view_flower);
        recycleViewFlower.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recycleViewFlower.setLayoutManager(mLayoutManager);

        // call flower api list
        Call<List<Flower>> call = request.getFlowersAPI();
        call.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {
                if (response != null) {
                    List<Flower> flowers = response.body();
                    if (flowers != null && flowers.size() > 0) {
                        FlowerImageAdapter adapter = new FlowerImageAdapter(FlowerActivity.this, flowers);
                        recycleViewFlower.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {
            }
        });
    }
}
