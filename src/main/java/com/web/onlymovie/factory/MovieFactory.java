package com.web.onlymovie.factory;

import com.web.onlymovie.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class MovieFactory {

    @Autowired
    private SessionFactory sessionFactory;

    private static MovieFactory movieFactory = null;

    public List<Movie> getMovies() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("From Movie");
        List<Movie> movies = query.list();
        return movies;
    }

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

    public List<Movie> searchByName(String key){

        List<Movie> movies =  getMovies();
        System.out.println(movies);
        List<Movie> result = movies.stream().filter(movie -> movie.getTitle().contains(key)).collect(Collectors.toList());
        return movies;
    }
}
