package com.excrispy.moviecatalogservice.models;

import java.util.List;

public class Catalog {
    String id;
    List<Movie> movies;

    public Catalog() {}

    public Catalog(String id, List<Movie> movies) {
        this.id = id;
        this.movies = movies;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
