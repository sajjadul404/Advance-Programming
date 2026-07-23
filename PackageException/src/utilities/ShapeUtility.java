package utilities;

import shapes.Printable;

public class ShapeUtility {
    
    public static void displayAll(Printable[] shapes) {
        try {
            // Display all shapes
            for (int i = 0; i < shapes.length; i++) {
                System.out.print("Shape " + (i + 1) + ": ");
                shapes[i].printDetails();
            }
            
            // Intentionally try to access an invalid index to trigger exception
            System.out.println("\nAttempting to access invalid index...");
            shapes[shapes.length].printDetails(); // This will throw ArrayIndexOutOfBoundsException
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Attempted to access an invalid index of the array.");
        }
    }
}