package model;

public class Rating {
    RatingType type;
    int value;

    public Rating(int value) {
        this.type = RatingType.RATED;
        this.value = value;
    }

    public Rating() {
        this.type = RatingType.UNRATED;
        this.value = 0;
    }

    private enum RatingType {
        RATED,
        UNRATED

    }

}
