package library.model;

import library.service.Printable;

// Subclass representing a Digital Resource
public class DigitalResource extends LibraryResource implements Printable {

    // Constructor calling superclass constructor
    public DigitalResource(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    // Overriding calculateFine: Digital Resource fine is Rs. 2/day
    @Override
    public double calculateFine(int overdueDays) {
        if (overdueDays < 0) return 0.0;
        return overdueDays * 2.0;
    }

    // Overriding printDetails from Printable interface
    @Override
    public void printDetails() {
        System.out.println("---------- [ DIGITAL RESOURCE ] ----------");
        printBaseInfo(); // calling protected superclass method
        System.out.println("Resource Type: Digital Resource / Media");
        System.out.println("Fine Rate    : Rs. 2.00 / day");
        System.out.println("-------------------------------------------");
    }
}
