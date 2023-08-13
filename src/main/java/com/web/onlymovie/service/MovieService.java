package com.web.onlymovie.service;

import com.web.onlymovie.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    public List<Movie> getMovies();

    public void saveMovie(Movie movie);

    public void deleteMovie(int id);

    public Movie getMovie(int id);

}
