package model;

public class Movie {
    private String name;
    private Year year;
    private String director;
    private Rating rating;

    public Movie(String name, Year year, String director, Rating rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }
}
