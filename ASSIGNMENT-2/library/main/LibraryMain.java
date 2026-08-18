package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.service.Printable;
import library.util.InputValidator;

// Main driver program for Smart Library Resource Management System
public class LibraryMain {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("    " + LibraryResource.libraryName.toUpperCase());
        System.out.println("==================================================\n");

        // i. Create at least five objects
        // ii. Store them in an array of LibraryResource
        LibraryResource[] resources = new LibraryResource[5];
        resources[0] = new Book(101, "Introduction to Java Programming", "Y. Daniel Liang");
        resources[1] = new DigitalResource(102, "AI & Machine Learning Research Guide", "Dr. Andrew Ng");
        resources[2] = new Book(103, "Data Structures and Algorithms in Java", "Robert Lafore");
        resources[3] = new DigitalResource(104, "Cloud Computing Architecture PDF", "Martin Fowler");
        resources[4] = new Book(105, "Clean Code", "Robert C. Martin");

        // Overdue days for each resource (e.g. resource 0 has 4 overdue days, etc.)
        int[] overdueDays = {4, 7, 0, 10, 2};

        // iii. Display complete details
        System.out.println("=== 1. DISPLAYING RESOURCE DETAILS ===");
        for (LibraryResource resource : resources) {
            // Validate Resource ID
            if (!InputValidator.validateResourceId(resource.getResourceId())) {
                System.out.println("Error: Invalid Resource ID for resource: " + resource.getTitle());
                continue;
            }

            if (resource instanceof Printable) {
                ((Printable) resource).printDetails();
            }
        }

        // iv. Calculate total fine of all overdue resources
        System.out.println("\n=== 2. OVERDUE FINE CALCULATIONS ===");
        double totalFineAllResources = 0.0;

        for (int i = 0; i < resources.length; i++) {
            LibraryResource res = resources[i];
            int days = overdueDays[i];

            if (!InputValidator.validateFineDays(days)) {
                System.out.println("Invalid overdue days specified for Resource ID: " + res.getResourceId());
                continue;
            }

            double fine = res.calculateFine(days);
            totalFineAllResources += fine;

            System.out.printf("Resource ID %d (%s)\n  -> Overdue Days: %d day(s) | Fine Rate: Rs. %.2f/day | Total Fine: Rs. %.2f\n",
                    res.getResourceId(), res.getTitle(), days,
                    (res instanceof Book ? 5.0 : 2.0), fine);
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL FINE FOR ALL OVERDUE RESOURCES: Rs. %.2f\n", totalFineAllResources);
        System.out.println("--------------------------------------------------");

        // Display static object counter
        System.out.println();
        LibraryResource.displayTotalResourcesCreated();
        System.out.println("==================================================");
    }
}
