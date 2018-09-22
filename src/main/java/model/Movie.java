package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return name.equals(movie.name) &&
                year.equals(movie.year) &&
                director.equals(movie.director) &&
                rating.equals(movie.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, director, rating);
    }

    @Override
    public String toString() {
        return "" + name + "-" + year +
                "-" + director + "-" + rating + "\n";
    }
}
