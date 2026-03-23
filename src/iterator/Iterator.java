package iterator;

/**
 * Iterator interface — defines the traversal contract.
 *
 * The Iterator pattern separates the traversal logic from the collection itself.
 * Any class that implements this interface can be used to step through a collection
 * without exposing its internal structure.
 */
public interface Iterator<T> {

    /** Returns true if there are more elements to visit. */
    boolean has_next();

    /** Returns the next element and advances the cursor. */
    T next();
}