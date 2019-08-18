package com.example.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class MoviesApiManager {
    private final String BASE_URL = "http://api.androidhive.info/";
    private static MoviesApiManager moviesApiManager;
    private Retrofit retrofit;

    private MoviesApiManager(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
    }

    static MoviesApiManager getInstance(){
        if(moviesApiManager == null){
            moviesApiManager = new MoviesApiManager();
        }
        return moviesApiManager;
    }

    MoviesService getMoviesApi(){
        return retrofit.create(MoviesService.class);
    }
}
