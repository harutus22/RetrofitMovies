package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Movie {
    @SerializedName("title")
    @Expose
    private String movieTitle;
    @SerializedName("image")
    @Expose
    private String moviePoster;
    @SerializedName("rating")
    @Expose
    private String movieRating;
    @SerializedName("releaseYear")
    @Expose
    private String releaseYear;
    @SerializedName("genre")
    @Expose
    private ArrayList<String> genres;

    public Movie(String movieTitle, String moviePoster, String movieRating, String releaseYear, ArrayList<String> genres) {
        this.movieTitle = movieTitle;
        this.moviePoster = moviePoster;
        this.movieRating = movieRating;
        this.releaseYear = releaseYear;
        this.genres = genres;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }
}
