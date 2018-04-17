package com.app.dagger2withmvc.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.app.dagger2withmvc.App;
import com.app.dagger2withmvc.di.component.AppComponent;


public abstract class BaseActivity extends AppCompatActivity {

    abstract public void injectAppComponent(AppComponent appComponent);


    // Inject to All Activity
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectAppComponent(((App) getApplication()).getAppComponent());
    }
}
