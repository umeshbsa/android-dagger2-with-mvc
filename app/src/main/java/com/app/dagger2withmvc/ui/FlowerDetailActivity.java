package com.app.dagger2withmvc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.dagger2withmvc.R;
import com.app.dagger2withmvc.di.component.AppComponent;
import com.app.dagger2withmvc.listner.IApiService;
import com.app.dagger2withmvc.model.Flower;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

public class FlowerDetailActivity extends BaseActivity {

    // Inject to get instance of IApiService from NetModule
    @Inject
    IApiService request;
    private TextView tvName;
    private TextView tvId;
    private ImageView ivPhoto;
    private TextView tvPhoto;
    private TextView tvCategory;
    private TextView tvDesc;
    private TextView tvPrice;

    // Set to this activity with AppComponent
    @Override
    public void injectAppComponent(AppComponent appComponent) {
        appComponent.plus(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_detail);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvId = (TextView) findViewById(R.id.tv_id);
        ivPhoto = (ImageView) findViewById(R.id.iv_photo);
        tvPhoto = (TextView) findViewById(R.id.tv_photo);
        tvPrice = (TextView) findViewById(R.id.tv_price);
        tvCategory = (TextView) findViewById(R.id.tv_category);
        tvDesc = (TextView) findViewById(R.id.tv_desc);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Flower flower = (Flower) bundle.getSerializable("DATA");
                tvName.setText(flower.getName());
                tvId.setText(String.valueOf(flower.getProductId()));
                tvPrice.setText(String.valueOf(flower.getPrice()));
                tvPhoto.setText(flower.getPhoto());
                tvCategory.setText(flower.getCategory());
                tvDesc.setText(flower.getInstructions());
                Glide.with(this).load("http://services.hanselandpetal.com/photos/" + flower.getPhoto()).into(ivPhoto);
            }
        }
    }
}
