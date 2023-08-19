package com.web.onlymovie.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Movie")
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private int year;

    @Column(name = "genres")
    private String genres;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "language")
    private String language;

    @Column(name = "url")
    private String url;

    @Column(name = "image")
    private String image;


    public Movie(){};

    public Movie(String title, int year, String genres, Double rating, String language, String url, String image) {
        this.title = title;
        this.year = year;
        this.genres = genres;
        this.rating = rating;
        this.language = language;
        this.url = url;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genres='" + genres + '\'' +
                ", rating=" + rating +
                '}';
    }
}
