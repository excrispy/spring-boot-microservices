package com.excrispy.ratingsdataservice.models;

public class Rating {
    String movieName;
    String movieId;
    int rating;

    public Rating() {}

    public Rating(String movieName, String movieId, int rating) {
        this.movieName = movieName;
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
