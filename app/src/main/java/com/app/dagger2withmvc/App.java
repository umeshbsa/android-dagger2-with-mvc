package com.app.dagger2withmvc;


import android.app.Application;

import com.app.dagger2withmvc.di.component.AppComponent;
import com.app.dagger2withmvc.di.component.DaggerAppComponent;
import com.app.dagger2withmvc.di.module.AppModule;
import com.app.dagger2withmvc.di.module.NetModule;


public class App extends Application {

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Add all module here
        // Here Gson module is not add because this module is used only in NetModule and we do not inject any activity so that it is not required to add here.
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com/"))
                .build();
    }
}
