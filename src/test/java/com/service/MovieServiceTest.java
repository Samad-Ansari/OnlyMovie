package com.service;

import com.web.onlymovie.factory.MovieFactory;
import static org.junit.Assert.*;

import com.web.onlymovie.model.Movie;
import com.web.onlymovie.service.MovieService;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MovieServiceTest {

    private MovieFactory movieFactoryMock;
    private MovieService movieService;
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        movieFactoryMock = EasyMock.createNiceMock(MovieFactory.class);
        movieService = new MovieService();
        movieService.setMovieFactory(movieFactoryMock);
    }

    @After
    public void tearDown(){
        EasyMock.verify(movieFactoryMock);
        EasyMock.reset(movieFactoryMock);
    }

    @Test
    public void testGetMovies(){
        List<Movie> mockMovies = new ArrayList<>();
        mockMovies.add(new Movie("title1", 2000, "Action", 8.0, "English", "url1", "image1"));
        mockMovies.add(new Movie("title2", 2000, "Action", 8.0, "English", "url2", "image2"));

        EasyMock.expect(movieFactoryMock.getMovies()).andReturn(mockMovies);
        EasyMock.replay(movieFactoryMock);

        List<Movie> result = movieService.getMovies();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("title1", result.get(0).getTitle());
        assertEquals("title2", result.get(1).getTitle());
    }

    @Test
    public void testSaveMovie(){
        Movie movie = new Movie("title1", 2000, "Action", 8.0, "English", "url1", "image1");

        movieFactoryMock.saveMovie(movie);
        EasyMock.replay(movieFactoryMock);

        movieService.saveMovie(movie);
    }

    @Test
    public void testDeleteMovie(){
        int movieId = 1;

        movieFactoryMock.deleteMovie(movieId);
        EasyMock.replay(movieFactoryMock);

        movieService.deleteMovie(movieId);
    }

    @Test
    public void testGetMovie(){
        int movieId = 1;
        Movie movie = new Movie("title1", 2000, "Action", 8.0, "English", "url1", "image1");
        movie.setId(movieId);

        EasyMock.expect(movieFactoryMock.getMovie(movieId)).andReturn(movie);
        EasyMock.replay(movieFactoryMock);

        Movie result = movieService.getMovie(movieId);

        assertNotNull(result);
        assertEquals(movieId, result.getId());
        assertEquals(movie.getTitle(), result.getTitle());
        assertEquals(movie.getYear(), result.getYear());
        assertEquals(movie.getGenres(), result.getGenres());
        assertEquals(movie.getRating(), result.getRating());
        assertEquals(movie.getLanguage(), result.getLanguage());
        assertEquals(movie.getUrl(), result.getUrl());
        assertEquals(movie.getImage(), result.getImage());
    }

}
