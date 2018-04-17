package com.app.dagger2withmvc.di.component;


import com.app.dagger2withmvc.App;
import com.app.dagger2withmvc.di.module.AppModule;
import com.app.dagger2withmvc.di.module.GsonModule;
import com.app.dagger2withmvc.di.module.NetModule;
import com.app.dagger2withmvc.ui.FlowerActivity;
import com.app.dagger2withmvc.ui.FlowerDetailActivity;

import javax.inject.Singleton;

import dagger.Component;


// AppComponent : Insert all module here like - AppModule, GsonModule, NetModule
@Singleton
@Component(modules = {AppModule.class, GsonModule.class, NetModule.class})
public interface AppComponent {

    void inject(App app);

    void plus(FlowerActivity flowerActivity);

    void plus(FlowerDetailActivity flowerDetailActivity);
}
