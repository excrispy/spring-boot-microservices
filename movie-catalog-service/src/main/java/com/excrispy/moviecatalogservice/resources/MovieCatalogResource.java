package com.excrispy.moviecatalogservice.resources;

import com.excrispy.moviecatalogservice.models.Catalog;
import com.excrispy.moviecatalogservice.models.Movie;
import com.excrispy.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
@EnableEurekaClient
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{id}")
    public Catalog getMovieList(@PathVariable("id") String id) {
        Catalog catalog = new Catalog(id, new ArrayList<>());
        UserRating user = restTemplate.getForObject("http://ratings-data-service/ratings-data/users/" + id, UserRating.class);
        user.getRatings().forEach(d -> {
            Movie movie = restTemplate.getForObject("http://movies-info-service/movies/" + d.getMovieId(), Movie.class);
            catalog.addMovie(movie);
        });

        return catalog;
    }
}
