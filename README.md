# Android Dagger2 with MVC design pattern
This is example of android dagger2 with brief code by using mvc design pattern.

<p align="left">
  <img src="https://github.com/umeshbsa/android-dagger2-with-mvc/blob/master/screen/screen_1.png" width="350"/>
</p>

1. Add code in application class project
```java
 appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com/"))
                .build();
 ```           
 2. Create AppComponent
 ```java
 @Singleton
@Component(modules = {AppModule.class, GsonModule.class, NetModule.class})
public interface AppComponent {
    void inject(App app);
    void plus(FlowerActivity flowerActivity);
    void plus(FlowerDetailActivity flowerDetailActivity);
}
```
3. Create Module
```java

@Module
public class AppModule {
    private final Application application;
    public AppModule(Application application) {
        this.application = application;
    }
    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }
}

@Module
public class GsonModule {
    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }
}

@Module
public class NetModule {
    private final String url;
    public NetModule(String url) {
        this.url = url;
    }
    add complete code here ...................................................
```
Run this project and enjoy with dagger2 with mvc pattern...
          
