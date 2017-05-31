package com.example.shadwo.retrotutapp.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.shadwo.retrotutapp.Service.ApiClient;
import com.example.shadwo.retrotutapp.Service.ApiInterface;
import com.example.shadwo.retrotutapp.MainActivity;
import com.example.shadwo.retrotutapp.Model.News;
import com.example.shadwo.retrotutapp.Model.NewsResponse;
import com.example.shadwo.retrotutapp.Views.NewsView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shadwo on 5/31/2017.
 */

public class NewsPresenterImpl implements  NewsPresenter{
    private static final String TAG = MainActivity.class.getSimpleName();
    private Context context;
    private NewsPresenterListener newsPresenterListener;
    NewsView newsView;
    private ApiInterface apiInterface;

    public NewsPresenterImpl(Context context, NewsPresenterListener newsPresenterListener) {
        this.context = context;
        this.newsPresenterListener = newsPresenterListener;
        this.apiInterface= ApiClient.getClient().create(ApiInterface.class);
    }

    public NewsPresenterImpl(Context context, NewsView newsView) {
        this.context = context;
        this.newsView = newsView;
        this.apiInterface= ApiClient.getClient().create(ApiInterface.class);
    }

    public interface NewsPresenterListener{
        void countriesReady(List<News> newsList);
    }
    @Override
    public void getNews(){
        Call<NewsResponse> call = apiInterface.getAnswers();
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse>call, Response<NewsResponse> response) {
                newsView.init();
                List<News> newsList = response.body().getResults();
                newsView.countriesReady(newsList);
                newsView.lodaFinish();
            //    newsPresenterListener.countriesReady(newsList);
                Log.d(TAG, "Number of movies received: " + newsList.size());


            }

            @Override
            public void onFailure(Call<NewsResponse>call, Throwable t) {
                // Log error here since request failed

            }
        });

    }
}