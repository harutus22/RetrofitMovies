package com.example.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MoviesRecyclerViewAdapter extends RecyclerView.Adapter<MoviesRecyclerViewHolder> {
    private ArrayList<Movie> movies;
    private Context context;
    private OnMovieClicked onMovieClicked;
    private MoviesRecyclerViewHolder.OnMovieClickListener onMovieClickListener
            = new MoviesRecyclerViewHolder.OnMovieClickListener() {
        @Override
        public void onMovieClicked(int position) {
            onMovieClicked.onMovieClicked(movies.get(position));
        }
    };

    public MoviesRecyclerViewAdapter(Context context, ArrayList<Movie> movies){
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MoviesRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.movies_recycler_view, viewGroup, false);
        MoviesRecyclerViewHolder moviesHolder = new MoviesRecyclerViewHolder(view);
        moviesHolder.setOnMovieClickListener(onMovieClickListener);
        return moviesHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesRecyclerViewHolder moviesRecyclerViewHolder, int i) {
        Movie movie = movies.get(i);
        Picasso.with(context).load(movie.getMoviePoster()).into(moviesRecyclerViewHolder.getMoviePoster());
        moviesRecyclerViewHolder.getMovieTitle().setText(movie.getMovieTitle());
        moviesRecyclerViewHolder.getMovieRating().setText(movie.getMovieRating());
        moviesRecyclerViewHolder.getMovieReleaseYear().setText(movie.getReleaseYear());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    interface OnMovieClicked{
        void onMovieClicked(Movie movie);
    }

    public void setOnMovieClicked(OnMovieClicked onMovieClicked) {
        this.onMovieClicked = onMovieClicked;
    }
}
