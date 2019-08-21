package com.example.retrofit.remote;

import com.example.retrofit.model.CommentModel;
import com.example.retrofit.model.Movie;
import com.example.retrofit.model.PostModel;
import com.example.retrofit.staticValues.StaticNames;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MoviesService {
    @GET(StaticNames.MOVIES_API)
    Call<ArrayList<Movie>> getMovies();

    @GET("posts/{id}/comments")
    Call<ArrayList<CommentModel>> getComments(@Path("id") int position);

    @GET("posts")
    Callback<ArrayList<PostModel>> getPostById(@Query("user_id") int userId);

    @GET("posts")
    Call<ArrayList<PostModel>> getDataMap(@QueryMap Map<String, String> params);
}
