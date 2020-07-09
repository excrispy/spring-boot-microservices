package com.excrispy.ratingsdataservice.resources;

import com.excrispy.ratingsdataservice.models.Rating;
import com.excrispy.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ratings-data")
public class RatingsDataResource {
    List<Rating> ratings;
    List<UserRating> userRatings;

    public RatingsDataResource() {
        ratings = new ArrayList<Rating>();
        ratings.add(new Rating("Terminator", "1", 5));
        ratings.add(new Rating("Transformers", "2", 3));

        userRatings = new ArrayList<UserRating>();
        userRatings.add(new UserRating("5", ratings));
        userRatings.add(new UserRating("6", ratings));
    }

    @RequestMapping("/ratings")
    public List<Rating> getRatings() {
        return ratings;
    }

    @RequestMapping("/ratings/{movieName}")
    public Rating getRating(@PathVariable String movieName) {
        Rating match = ratings
                .stream()
                .filter(d -> d.getMovieName().equals(movieName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No rating found with the name: "+ movieName));

        return match;
    }

    @RequestMapping("/users")
    public List<UserRating> getUsers() {
        return userRatings;
    }

    @RequestMapping("/users/{id}")
    public UserRating getUserRating(@PathVariable String id) {
        UserRating match = userRatings
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No rating found with the name: "+ id));

        return match;
    }
}
