package com.example.retrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {
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
    private String[] genres;

    private Movie(){}

    public Movie(String movieTitle, String moviePoster, String movieRating, String releaseYear, String[] genres) {
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

    public String[] getGenres() {
        return genres;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movieTitle);
        dest.writeString(moviePoster);
        dest.writeString(movieRating);
        dest.writeString(releaseYear);
        dest.writeStringArray(genres);
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return Movie.createFromParcel(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    private static Movie createFromParcel(Parcel source){
        Movie movie = new Movie();
        movie.movieTitle = source.readString();
        movie.moviePoster = source.readString();
        movie.movieRating = source.readString();
        movie.releaseYear = source.readString();
        movie.genres = source.createStringArray();
        return movie;
    }
}
