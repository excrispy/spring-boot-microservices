package com.excrispy.movieinfoservice.resources;

import com.excrispy.movieinfoservice.models.Movie;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
    List<Movie> movies;

    public MovieInfoResource() {
        movies = new ArrayList<Movie>();
        movies.add(new Movie("1", "Terminator", "Action"));
        movies.add(new Movie("2", "Transformers", "Thriller"));
    }

    @RequestMapping("")
    public List<Movie> getMovies() {
        return movies;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Movie getMovie(@PathVariable("id") String id) throws Error {
        Movie match = movies
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No products found with the  product id: "+ id));

        return match;
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public Movie addMovie(@RequestBody Movie movie) {
        movies.add(movie);
        return movie;
    }
}
