package com.example.shadwo.retrotutapp.Module;

import android.content.Context;

import com.example.shadwo.retrotutapp.Presenter.NewsPresenter;
import com.example.shadwo.retrotutapp.Presenter.NewsPresenterImpl;
import com.example.shadwo.retrotutapp.Views.NewsView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by DTL on 27-Jul-17.
 */
@Module
public class PresenterModule {
    @Provides
    @Singleton
    NewsPresenter provideNewsPresenter(Context context) {
        return new NewsPresenterImpl(context);
    }

}
