package com.example.shadwo.retrotutapp.Service;

import com.example.shadwo.retrotutapp.Model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shadwo on 5/30/2017.
 */

public interface ApiInterface {
    @GET("v1/articles?source=google-news&sortBy=top&apiKey=a4ec074faab34f42bde4dbb899b75ae5")
    Call<NewsResponse> getAnswers();
}
