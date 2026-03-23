package iterator;

/**
 * BookIterator — a concrete iterator for BookCollection.
 *
 * Knows how to traverse a BookCollection from start to finish.
 * Keeps a cursor (current index) as its only state.
 *
 * Key insight: the traversal logic lives here, not in the collection.
 * You could create a ReverseBookIterator or FilteringBookIterator without
 * touching BookCollection at all.
 */
public class BookIterator implements Iterator<Book> {

    private final BookCollection collection;

    // The cursor tracks where we are in the traversal
    private int cursor = 0;

    public BookIterator(BookCollection collection) {
        this.collection = collection;
    }

    /**
     * Returns true as long as there are unvisited books.
     * Does not advance the cursor.
     */
    @Override
    public boolean has_next() {
        return cursor < collection.get_count();
    }

    /**
     * Returns the current book and moves the cursor forward.
     * Call has_next() before calling next() to avoid going out of bounds.
     */
    @Override
    public Book next() {
        return collection.get_book_at(cursor++);
    }
}