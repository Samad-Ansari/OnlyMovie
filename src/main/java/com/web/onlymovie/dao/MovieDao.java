package com.web.onlymovie.dao;

import com.web.onlymovie.model.Movie;

import java.util.List;

public interface MovieDao {

    public List<Movie> getMovies();

    public void saveMovie(Movie movie);

    public void deleteMovie(int id);

    public Movie getMovie(int id);

}
