package com.example.movieapp.view.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieapp.model.Movie;
import com.example.movieapp.R;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE_ID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int movieId = (int) getIntent().getExtras().get(EXTRA_MOVIE_ID);
        String movieName = Movie.movies[movieId].getName();
        TextView textView = findViewById(R.id.info_detail_text);
        textView.setText(movieName);
        int movieImage = Movie.movies[movieId].getImageResourceId();
        ImageView imageView = findViewById(R.id.info_detail_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, movieImage));
        imageView.setContentDescription(movieName);


    }
}
