package iterator;

/**
 * BookCollection — a concrete aggregate (the collection).
 *
 * Stores books in a fixed-size array. The client code never accesses
 * the array directly — it always goes through an iterator.
 *
 * Notice that BookCollection knows nothing about how it will be traversed.
 * That responsibility belongs entirely to BookIterator.
 */
public class BookCollection implements Aggregate<Book> {

    // Internal storage — hidden from the outside world
    private final Book[] books;
    private int count = 0;

    public BookCollection(int capacity) {
        this.books = new Book[capacity];
    }

    /** Adds a book to the collection. */
    public void add_book(Book book) {
        if (count < books.length) {
            books[count++] = book;
        }
    }

    /** Returns the number of books currently stored. */
    public int get_count() {
        return count;
    }

    /**
     * Package-private: the iterator needs access to the array,
     * but external clients should not.
     */
    Book get_book_at(int index) {
        return books[index];
    }

    /**
     * Factory method — creates an iterator for this collection.
     * The collection decides which iterator to hand out.
     */
    @Override
    public Iterator<Book> create_iterator() {
        return new BookIterator(this);
    }
}