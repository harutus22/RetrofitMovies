package com.example.retrofit.remote;

import com.example.retrofit.staticValues.StaticNames;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesApiManager {
    private static MoviesApiManager moviesApiManager;
    private Retrofit retrofit;

    private MoviesApiManager(){
        retrofit = new Retrofit.Builder().baseUrl(StaticNames.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
    }

    public static MoviesApiManager getInstance(){
        if(moviesApiManager == null){
            moviesApiManager = new MoviesApiManager();
        }
        return moviesApiManager;
    }

    public MoviesService getMoviesApi(){
        return retrofit.create(MoviesService.class);
    }
}
