package com.web.onlymovie.controller;

import com.web.onlymovie.model.Movie;
import com.web.onlymovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/list")
    public String listMovies(Model model) {
        List<Movie> movies = movieService.getMovies();
        model.addAttribute("movieList", movies);
        return "list-movies";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "movie-form";
    }

    @PostMapping("/saveMovie")
    public String saveCustomer(@ModelAttribute("movie") Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movie/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("movieId") int theId,
                                    Model model) {
        Movie movie = movieService.getMovie(theId);
        model.addAttribute("movie", movie);
        return "movie-form";
    }

    @GetMapping("/delete")
    public String deleteMovie(@RequestParam("movieId") int theId) {
        movieService.deleteMovie(theId);
        return "redirect:/movie/list";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam("key") String title, Model model){
        List<Movie> movies = movieService.searchByName(title);
        model.addAttribute("movieList", movies);
        return "search-movie";
    }
}
