package library.model;

import library.service.Printable;

// Subclass representing a physical Book resource
public class Book extends LibraryResource implements Printable {

    // Constructor calling superclass constructor
    public Book(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    // Overriding calculateFine: Book fine is Rs. 5/day
    @Override
    public double calculateFine(int overdueDays) {
        if (overdueDays < 0) return 0.0;
        return overdueDays * 5.0;
    }

    // Overriding printDetails from Printable interface
    @Override
    public void printDetails() {
        System.out.println("------------- [ BOOK RESOURCE ] -------------");
        printBaseInfo(); // calling protected superclass method
        System.out.println("Resource Type: Physical Book");
        System.out.println("Fine Rate    : Rs. 5.00 / day");
        System.out.println("---------------------------------------------");
    }
}
