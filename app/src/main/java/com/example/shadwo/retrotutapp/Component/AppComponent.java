package com.example.shadwo.retrotutapp.Component;

import com.example.shadwo.retrotutapp.MainActivity;
import com.example.shadwo.retrotutapp.Module.AppModule;
import com.example.shadwo.retrotutapp.Module.NetworkModule;
import com.example.shadwo.retrotutapp.Module.PresenterModule;
import com.example.shadwo.retrotutapp.Presenter.NewsPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by DTL on 27-Jul-17.
 */
@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, NetworkModule.class})

public interface AppComponent {
    void inject(MainActivity target);
    void inject(NewsPresenterImpl target);


}
