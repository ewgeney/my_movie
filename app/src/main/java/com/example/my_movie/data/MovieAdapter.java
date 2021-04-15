package com.example.my_movie.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_movie.R;
import com.example.my_movie.model.Movies;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    Context context;
    ArrayList<Movies> allMovies;

    public MovieAdapter(Context context, ArrayList<Movies> arrayList) {
        this.context = context;
        allMovies = arrayList;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.movies_item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

        Movies thisMovies = allMovies.get(position);

        String title = thisMovies.getTitle();
        String year = thisMovies.getYear();
        String posterUrl = thisMovies.getPosterUrl();

        holder.titleTextView.setText(title);
        holder.yearTextView.setText(year);
        Picasso.get().load(posterUrl).into(holder.posterImageView);


    }

    @Override
    public int getItemCount() {
        return allMovies.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        TextView yearTextView;
        ImageView posterImageView;


        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            posterImageView = itemView.findViewById(R.id.posterImageView);
        }
    }
}
