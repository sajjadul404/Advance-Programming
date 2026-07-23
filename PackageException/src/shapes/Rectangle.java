package shapes;

public class Rectangle implements Printable {
    private double length;
    private double width;
    
   
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
 
    public double getLength() {
        return length;
    }
    
    public double getWidth() {
        return width;
    }
  
    public double area() {
        return length * width;
    }
    
 
    public double perimeter() {
        return 2 * (length + width);
    }
    

    public void printDetails() {
        System.out.printf("Rectangle: Area = %.1f, Perimeter = %.1f%n", 
                         area(), perimeter());
    }
}