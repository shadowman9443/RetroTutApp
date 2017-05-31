package com.example.shadwo.retrotutapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.shadwo.retrotutapp.Model.News;
import com.example.shadwo.retrotutapp.Presenter.NewsPresenter;
import com.example.shadwo.retrotutapp.Presenter.NewsPresenterImpl;
import com.example.shadwo.retrotutapp.Views.NewsView;
import com.example.shadwo.retrotutapp.adapter.MoviesAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsView{
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    ProgressDialog mProgressDialog;
   // private NewsPresenterImpl newsPresenter;
    NewsPresenter newsPresenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        newsPresenter=new NewsPresenterImpl(this,this);
        newsPresenter.getNews();
        mProgressDialog = new ProgressDialog(this);

       /* ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<NewsResponse> call = apiService.getAnswers();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse>call, Response<NewsResponse> response) {
                List<News> movies = response.body().getResults();
                mAdapter=new MoviesAdapter(movies, R.layout.news_layout, getApplicationContext());
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                recyclerView.setAdapter(mAdapter);
                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
                Log.d(TAG, "Number of movies received: " + movies.size());
            }

            @Override
            public void onFailure(Call<NewsResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
            }
        });*/
    }

    @Override
    public void countriesReady(List<News> newsList) {


        mAdapter=new MoviesAdapter(newsList, R.layout.news_layout, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);


    }

    @Override
    public void init() {

        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        progressBar.setVisibility(View.VISIBLE);


    }

    @Override
    public void lodaFinish() {
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        progressBar.setVisibility(View.INVISIBLE);
    }
}
