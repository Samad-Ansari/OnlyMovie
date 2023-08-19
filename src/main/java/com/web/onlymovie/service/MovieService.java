package com.web.onlymovie.service;

import com.web.onlymovie.factory.MovieFactory;
import com.web.onlymovie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class MovieService {

    @Autowired
    private MovieFactory movieFactory;

    public MovieFactory getMovieFactory() {
        return movieFactory;
    }

    public void setMovieFactory(MovieFactory movieFactory) {
        this.movieFactory = movieFactory;
    }

    @Transactional
    public List<Movie> getMovies() {
        return movieFactory.getMovies();
    }

    @Transactional
    public void saveMovie(Movie movie) {
        movieFactory.saveMovie(movie);
    }

    @Transactional
    public void deleteMovie(int id) {
        movieFactory.deleteMovie(id);
    }

    @Transactional
    public Movie getMovie(int id) {
        return movieFactory.getMovie(id);
    }

    @Transactional
    public List<Movie> searchByTitle(String key) {
        return movieFactory.searchByTitle(key);
    }

}
