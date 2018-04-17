# Android Dagger2 with MVC design pattern
This is example of android dagger2 with brief code by using mvc design pattern.

<p align="left">
  <img src="https://github.com/umeshbsa/android-dagger2-with-mvc/blob/master/screen/screen_1.png" width="350"/>
</p>

1. Add code in application class project
 appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com/"))
                .build();
