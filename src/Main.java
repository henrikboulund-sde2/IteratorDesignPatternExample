import iterator.Book;
import iterator.BookCollection;
import iterator.Iterator;
import iterator.ReverseBookIterator;

/**
 * Iterator Design Pattern — Console Demo
 *
 * Pattern participants:
 *   Iterator       (interface)  — has_next() / next()
 *   Aggregate      (interface)  — create_iterator()
 *   BookIterator   (concrete)   — forward traversal
 *   BookCollection (concrete)   — the collection
 *
 * The client (this class) only talks to the Iterator interface.
 * It has no knowledge of how the collection stores its data.
 */
public class Main {

    public static void main(String[] args) {

        // --- Build the collection ---
        BookCollection library = new BookCollection(10);
        library.add_book(new Book("Clean Code",            "Robert C. Martin", 2008));
        library.add_book(new Book("Design Patterns",       "Gang of Four",     1994));
        library.add_book(new Book("The Pragmatic Programmer", "Hunt & Thomas", 1999));
        library.add_book(new Book("Refactoring",           "Martin Fowler",    2018));
        library.add_book(new Book("Head First Design Patterns", "Freeman et al.", 2004));

        // --- Demo 1: Forward iteration using the default iterator ---
        System.out.println("=== Forward traversal ===");
        Iterator<Book> forward = library.create_iterator();

        while (forward.has_next()) {
            Book book = forward.next();
            System.out.println("  " + book);
        }

        // --- Demo 2: Reverse iteration using an alternative iterator ---
        // The collection hasn't changed — only the iterator is different.
        System.out.println("\n=== Reverse traversal ===");
        Iterator<Book> reverse = new ReverseBookIterator(library);

        while (reverse.has_next()) {
            Book book = reverse.next();
            System.out.println("  " + book);
        }

        // --- Demo 3: Multiple independent iterators on the same collection ---
        // Each iterator has its own cursor, so they don't interfere with each other.
        System.out.println("\n=== Two iterators running in parallel ===");
        Iterator<Book> first  = library.create_iterator();
        Iterator<Book> second = library.create_iterator();

        // Advance the second iterator by two steps ahead
        if (second.has_next()) second.next();
        if (second.has_next()) second.next();

        System.out.println("  Iterator 1 (from start) : " + first.next());
        System.out.println("  Iterator 2 (two ahead)  : " + second.next());
    }
}