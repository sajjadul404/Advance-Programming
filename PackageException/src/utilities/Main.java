package mainapp;

import shapes.Printable;
import shapes.Rectangle;
import utilities.ShapeUtility;

public class Main {
    public static void main(String[] args) {
        
        Printable[] shapes = new Printable[] {
            new Rectangle(5.0, 4.0),  
            new Rectangle(3.0, 2.0),
            new Rectangle(7.0, 3.0)    
        };
        
    
        ShapeUtility.displayAll(shapes);
    }
}