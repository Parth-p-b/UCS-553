package library.model;

// Abstract base class representing a generic library resource
public abstract class LibraryResource {
    // Private instance variables (Encapsulation)
    private int resourceId;
    private String title;
    private String author;

    // Static variable common across all resources
    public static String libraryName = "Global University Central Library";

    // Static object counter that counts every resource created
    private static int totalResourcesCreated = 0;

    // Constructor
    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
        totalResourcesCreated++; // Increment counter every time a resource object is instantiated
    }

    // Abstract method to calculate fine based on overdue days
    public abstract double calculateFine(int overdueDays);

    // Static method to display total resources created
    public static void displayTotalResourcesCreated() {
        System.out.println("Total Library Resources Created: " + totalResourcesCreated);
    }

    public static int getTotalResourcesCreated() {
        return totalResourcesCreated;
    }

    // Protected method accessible to subclasses to print core resource information
    protected void printBaseInfo() {
        System.out.println("Library Name : " + libraryName);
        System.out.println("Resource ID  : " + resourceId);
        System.out.println("Title        : " + title);
        System.out.println("Author       : " + author);
    }

    // Public Getters and Setters
    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
