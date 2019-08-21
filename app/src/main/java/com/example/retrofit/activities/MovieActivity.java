package com.example.retrofit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofit.model.Movie;
import com.example.retrofit.R;
import com.example.retrofit.staticValues.StaticNames;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

public class MovieActivity extends AppCompatActivity {
    private ImageView image;
    private TextView title;
    private TextView rating;
    private TextView releaseYear;
    private TextView genres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        initViews();

        setViewsInfo();
    }

    private void setViewsInfo() {
        Intent intent = getIntent();
        Movie movie = intent.getExtras().getParcelable(StaticNames.MOVIE_KEY);
        title.setText(movie.getMovieTitle());
        Picasso.with(this).load(movie.getMoviePoster()).into(image);
        String rate = StaticNames.RATING + movie.getMovieRating();
        rating.setText(rate);
        String realesY = StaticNames.REALESE_YEAR + movie.getReleaseYear();
        releaseYear.setText(realesY);
        String genre = StaticNames.GENRES + Arrays.toString(movie.getGenres());
        genres.setText(genre);

    }

    private void initViews() {
        image = findViewById(R.id.movieActivityImage);
        title = findViewById(R.id.movieActivityTitle);
        rating = findViewById(R.id.movieActivityRating);
        releaseYear = findViewById(R.id.movieActivityRealeseYear);
        genres = findViewById(R.id.movieActivityGenre);
    }
}
