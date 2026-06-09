package Box;

class Box {
    private int length;
    private int width;
    private int height;

    // Constructor
    Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // Method to adjust dimensions
    void adjustDimensions() {
        // Required dimensions
        int reqLength = 10;
        int reqWidth = 12;
        int reqHeight = 8;

        if (length < reqLength)
            length += (reqLength - length);
        else if (length > reqLength)
            length -= (length - reqLength);

        if (width < reqWidth)
            width += (reqWidth - width);
        else if (width > reqWidth)
            width -= (width - reqWidth);

        if (height < reqHeight)
            height += (reqHeight - height);
        else if (height > reqHeight)
            height -= (height - reqHeight);
    }

    // Display method
    void display() {
        System.out.println("Length = " + length + " meters");
        System.out.println("Width  = " + width + " meters");
        System.out.println("Height = " + height + " meters");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        // Create Box object
        Box box1 = new Box(9, 14, 10);

        System.out.println("Before Adjustment:");
        box1.display();

        // Adjust dimensions
        box1.adjustDimensions();

        System.out.println("After Adjustment:");
        box1.display();
    }
}