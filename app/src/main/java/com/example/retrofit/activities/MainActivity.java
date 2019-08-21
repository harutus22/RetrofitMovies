package com.example.retrofit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofit.model.Movie;

import com.example.retrofit.myRecyclerView.MoviesRecyclerViewAdapter;
import com.example.retrofit.remote.MoviesApiManager;
import com.example.retrofit.R;
import com.example.retrofit.staticValues.StaticNames;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> movies = new ArrayList<>();
    private MoviesRecyclerViewAdapter moviesAdapter;

    private MoviesRecyclerViewAdapter.OnMovieClicked clicked = new MoviesRecyclerViewAdapter.OnMovieClicked() {
        @Override
        public void onMovieClicked(Movie movie) {
            Intent intent = new Intent(getApplicationContext(), MovieActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable(StaticNames.MOVIE_KEY, movie);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MoviesApiManager moviesApiManager = MoviesApiManager.getInstance();
        Call<ArrayList<Movie>> call = moviesApiManager.getMoviesApi().getMovies();

        createRecycle(movies);
        sendRequest(call);
    }

    private void sendRequest(Call<ArrayList<Movie>> call) {
        call.enqueue(new Callback<ArrayList<Movie>>() {
            @Override
            public void onResponse(Call<ArrayList<Movie>> call, Response<ArrayList<Movie>> response) {
                if(response.isSuccessful()){
                    movies.addAll(response.body());
                    moviesAdapter.notifyDataSetChanged();




                    Toast.makeText(getApplicationContext(), StaticNames.SUCCESSFUL_OPERATION,
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),StaticNames.UNSUCCESSFUL_OPERATION ,
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Movie>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), StaticNames.FAILED_OPERATION,
                        Toast.LENGTH_LONG).show();
                Log.d(StaticNames.TAG, t.getMessage());
            }
        });
    }

    private void createRecycle(ArrayList<Movie> movies){
        RecyclerView moviesRecyclerView = findViewById(R.id.moviesRecyclerView);
        moviesAdapter = new MoviesRecyclerViewAdapter(this, movies);
        moviesAdapter.setOnMovieClicked(clicked);
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        moviesRecyclerView.setAdapter(moviesAdapter);

    }
}
