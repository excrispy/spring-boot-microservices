package com.excrispy.ratingsdataservice.models;

import java.util.List;

public class UserRating {
    String id;
    List<Rating> ratings;

    public UserRating() {}

    public UserRating(String id, List<Rating> ratings) {
        this.id = id;
        this.ratings = ratings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
