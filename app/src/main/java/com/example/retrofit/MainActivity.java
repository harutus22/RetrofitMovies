package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "Retrofit";
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MoviesApiManager.getInstance().getMoviesApi().getMovies().enqueue(new Callback<ArrayList<Movie>>() {
            @Override
            public void onResponse(Call<ArrayList<Movie>> call, Response<ArrayList<Movie>> response) {
                if(response.isSuccessful()){
                    movies = response.body();
                    createRecycle(movies);
                    Toast.makeText(getApplicationContext(), "Operation Successful",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Operation Is Not Successful",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Movie>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Operation Failed",
                        Toast.LENGTH_LONG).show();
                Log.d(TAG, t.getMessage());
            }
        });


    }

    private void createRecycle(ArrayList<Movie> movies){
        RecyclerView moviesRecyclerView = findViewById(R.id.moviesRecyclerView);
        MoviesRecyclerViewAdapter moviesAdapter = new MoviesRecyclerViewAdapter(this, movies);
        moviesRecyclerView.setAdapter(moviesAdapter);
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
