package com.example.shadwo.retrotutapp.Application;

import android.app.Application;

import com.example.shadwo.retrotutapp.Component.AppComponent;
import com.example.shadwo.retrotutapp.Component.DaggerAppComponent;
import com.example.shadwo.retrotutapp.Module.AppModule;

/**
 * Created by DTL on 27-Jul-17.
 */

public class RetroRxDragarMvpApplication extends Application{

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger(this);
    }

    protected AppComponent initDagger(RetroRxDragarMvpApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }
}
