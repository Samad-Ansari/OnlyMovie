package com.web.onlymovie.service;

import com.web.onlymovie.dao.MovieDao;
import com.web.onlymovie.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieDao movieDao;


    @Override
    @Transactional
    public List<Movie> getMovies() {
        return movieDao.getMovies();
    }

    @Override
    @Transactional
    public void saveMovie(Movie movie) {
        movieDao.saveMovie(movie);
    }

    @Override
    @Transactional
    public void deleteMovie(int id) {
        movieDao.deleteMovie(id);
    }

    @Override
    @Transactional
    public Movie getMovie(int id) {
        return movieDao.getMovie(id);
    }
}
