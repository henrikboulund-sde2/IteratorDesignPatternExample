package iterator;

/**
 * Aggregate interface — defines the factory method for creating an iterator.
 *
 * Any collection that wants to support iteration implements this interface.
 * The collection itself decides which iterator to return — the client doesn't
 * need to know how the collection is structured internally.
 */
public interface Aggregate<T> {

    /** Creates and returns an iterator for this collection. */
    Iterator<T> create_iterator();
}