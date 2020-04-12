package com.example.movieapp.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieapp.model.Movie;
import com.example.movieapp.R;
import com.example.movieapp.adapter.CardMovieAdapter;
import com.example.movieapp.view.activity.MovieDetailActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_movie, container, false);
        String[] movieNames = new String[Movie.movies.length];
        for (int i = 0; i < movieNames.length; i++) {
            movieNames[i] = Movie.movies[i].getName();
        }

        int[] movieImages = new int[Movie.movies.length];
        for (int i = 0; i < movieImages.length; i++) {
            movieImages[i] = Movie.movies[i].getImageResourceId();
        }

        CardMovieAdapter adapter = new CardMovieAdapter(movieNames, movieImages);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setListener(new CardMovieAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.EXTRA_MOVIE_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return recyclerView;
    }
}
