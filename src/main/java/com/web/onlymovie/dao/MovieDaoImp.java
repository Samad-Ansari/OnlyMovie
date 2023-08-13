package com.web.onlymovie.dao;

import com.web.onlymovie.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovieDaoImp implements MovieDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Movie> getMovies() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("From Movie");
        List<Movie> movies = query.list();
        return movies;
    }

    @Override
    public void saveMovie(Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.save(movie);
    }

    public void deleteMovie(int id) {
        Session session = sessionFactory.getCurrentSession();
        Movie movie = session.byId(Movie.class).load(id);
        session.delete(movie);
    }

    public Movie getMovie(int id) {
        Session session = sessionFactory.getCurrentSession();
        Movie movie = session.get(Movie.class, id);
        return movie;
    }
}
