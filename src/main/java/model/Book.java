package model;

public class Book extends Item {
    private String author;
    private Year year;

    public Book(String title, String author, Year year) {
        super(title,ItemType.BOOK);
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "" + title + "-" + author + "-" + year + "\n";
    }


}
