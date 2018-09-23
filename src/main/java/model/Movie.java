package model;

public class Movie extends Item {
    private Year year;
    private String director;
    private Rating rating;

    public Movie(String name, Year year, String director, Rating rating) {
        super(name,ItemType.MOVIE);
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "" + title + "-" + year +
                "-" + director + "-" + rating + "\n";
    }
}
