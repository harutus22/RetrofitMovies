package com.example.retrofit.myRecyclerView.myRecyclerViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofit.R;

public class MoviesRecyclerViewHolder extends RecyclerView.ViewHolder {
    private ImageView moviePoster;
    private TextView movieTitle;
    private TextView movieRating;
    private TextView movieReleaseYear;
    private OnMovieClickListener onMovieClickListener;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onMovieClickListener.onMovieClicked(getAdapterPosition());
        }
    };

    public MoviesRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        moviePoster = itemView.findViewById(R.id.moviePoster);
        movieTitle = itemView.findViewById(R.id.movieTitle);
        movieRating = itemView.findViewById(R.id.movieRating);
        movieReleaseYear = itemView.findViewById(R.id.movieReleaseYear);
        itemView.setOnClickListener(onClickListener);
    }

    public interface OnMovieClickListener{
        void onMovieClicked(int position);
    }

    public void setOnMovieClickListener(OnMovieClickListener onMovieClickListener) {
        this.onMovieClickListener = onMovieClickListener;
    }

    public ImageView getMoviePoster() {
        return moviePoster;
    }

    public TextView getMovieTitle() {
        return movieTitle;
    }

    public TextView getMovieRating() {
        return movieRating;
    }

    public TextView getMovieReleaseYear() {
        return movieReleaseYear;
    }
}
