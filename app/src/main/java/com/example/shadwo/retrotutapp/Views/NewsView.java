package com.example.shadwo.retrotutapp.Views;

import com.example.shadwo.retrotutapp.Model.News;

import java.util.List;

/**
 * Created by shadwo on 5/31/2017.
 */

public interface NewsView {
    void countriesReady(List<News> newsList);

    void init();

    void lodaFinish();

     void showErrorMessage();

}
