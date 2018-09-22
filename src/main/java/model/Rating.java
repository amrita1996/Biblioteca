package model;

import java.util.Objects;

public class Rating {
    private String value;

    private final String unRated = "UNRATED";

    public Rating(int value) {
        this.value = String.valueOf(value);
    }

    public Rating() {
        this.value = unRated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return value.equals(rating.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash( value);
    }

    @Override
    public String toString() {
        return "" + value;
    }


}
