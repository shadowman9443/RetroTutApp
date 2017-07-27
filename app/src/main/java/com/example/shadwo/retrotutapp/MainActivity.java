package com.example.shadwo.retrotutapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.shadwo.retrotutapp.Application.RetroRxDragarMvpApplication;
import com.example.shadwo.retrotutapp.Model.News;
import com.example.shadwo.retrotutapp.Presenter.NewsPresenter;
import com.example.shadwo.retrotutapp.Presenter.NewsPresenterImpl;
import com.example.shadwo.retrotutapp.Views.NewsView;
import com.example.shadwo.retrotutapp.adapter.MoviesAdapter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements NewsView{
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    ProgressDialog mProgressDialog;
   // private NewsPresenterImpl newsPresenter;
    NewsPresenter newsPresenter;
    private ProgressBar progressBar;


    @Inject
    NewsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((RetroRxDragarMvpApplication) getApplication()).getAppComponent().inject(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.progress);
       /* newsPresenter=new NewsPresenterImpl(this,this);
        newsPresenter.getNews();*/
     //   mProgressDialog = new ProgressDialog(this);

        presenter.setView(this);
        presenter.getNews();

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



        progressBar.setVisibility(View.VISIBLE);


    }

    @Override
    public void lodaFinish() {

        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
    }
}
