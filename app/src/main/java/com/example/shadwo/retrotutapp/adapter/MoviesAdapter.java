package com.example.shadwo.retrotutapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.example.shadwo.retrotutapp.Model.News;
import com.example.shadwo.retrotutapp.R;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by shadwo on 5/30/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<News> movies;
    private int rowLayout;
    private Context context;



    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView newsTitle;
        TextView date;
        TextView newsDescription;
        ImageView imageView;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.news_layout);
            newsTitle = (TextView) v.findViewById(R.id.txtTile);
            date = (TextView) v.findViewById(R.id.txtDate);
            newsDescription = (TextView) v.findViewById(R.id.txtDescription);
            imageView = (ImageView) v.findViewById(R.id.newsImage);
        }
    }

    public MoviesAdapter(List<News> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }




    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.newsTitle.setText(movies.get(position).getTitle());
        holder.date.setText(movies.get(position).getPublishedAt());
        holder.newsDescription.setText(movies.get(position).getDescription());
        DownloadImageTask downloadImageTask=  new DownloadImageTask( holder.imageView);


        downloadImageTask.execute(movies.get(position).getUrlToImage());


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;

        public DownloadImageTask(ImageView imageView) {
            imageViewReference = new WeakReference<ImageView>(imageView);
        }
        ImageView imageView = null;


        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];

            return downloadBitmap(urls[0]);
        }

        protected void onPostExecute(Bitmap bitmap ) {
            // bmImage.setImageBitmap(result);
            //imageView.setImageBitmap(result);
            if (imageViewReference != null) {
                ImageView imageView = imageViewReference.get();
                if (imageView != null) {
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    } else {
                        Drawable placeholder = imageView.getContext().getResources().getDrawable(R.drawable.bluworld);
                        imageView.setImageDrawable(placeholder);
                    }
                }
            }


        }
        private Bitmap downloadBitmap(String urldisplay){
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
                return  mIcon11;
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;

        }
    }
}