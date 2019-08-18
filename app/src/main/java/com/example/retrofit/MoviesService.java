package com.example.retrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesService {
    @GET("/json/movies.json")
    Call<ArrayList<Movie>> getMovies();
}
