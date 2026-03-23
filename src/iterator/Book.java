package iterator;

/**
 * Book — the element type stored in our collection.
 *
 * A simple value object representing a book in the library.
 */
public class Book {

    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String get_title() {
        return title;
    }

    public String get_author() {
        return author;
    }

    public int get_year() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" by %s (%d)", title, author, year);
    }
}