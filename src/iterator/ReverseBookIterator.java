package iterator;

/**
 * ReverseBookIterator — an alternative iterator for the same collection.
 *
 * Demonstrates that you can add new traversal strategies without modifying
 * the collection at all. The collection stays unchanged; only the iterator changes.
 *
 * This is the open/closed principle in action: open for extension, closed for modification.
 */
public class ReverseBookIterator implements Iterator<Book> {

    private final BookCollection collection;

    // Start at the last element and count down
    private int cursor;

    public ReverseBookIterator(BookCollection collection) {
        this.collection = collection;
        this.cursor = collection.get_count() - 1;
    }

    @Override
    public boolean has_next() {
        return cursor >= 0;
    }

    @Override
    public Book next() {
        return collection.get_book_at(cursor--);
    }
}