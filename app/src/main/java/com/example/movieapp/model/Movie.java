package com.example.movieapp.model;

import com.example.movieapp.R;

public class Movie {

    private String name;
    private int imageResourceId;

    public Movie(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public static final Movie[] movies = {
            new Movie("A Start is Born", R.drawable.poster_a_start_is_born),
            new Movie("Alita", R.drawable.poster_alita),
            new Movie("Aquaman", R.drawable.poster_aquaman),
            new Movie("Bohemian", R.drawable.poster_bohemian),
            new Movie("Cold Persuit", R.drawable.poster_cold_persuit),
            new Movie("Creed", R.drawable.poster_creed),
            new Movie("Crimes", R.drawable.poster_crimes),
            new Movie("Glass", R.drawable.poster_glass),
            new Movie("How to Train", R.drawable.poster_how_to_train),
            new Movie("Infinity War", R.drawable.poster_infinity_war),
            new Movie("Marry Queen", R.drawable.poster_marry_queen),
            new Movie("Spiderman", R.drawable.poster_spiderman),
    };

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
