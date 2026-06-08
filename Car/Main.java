package Car;

class Car {
    String make;
    String model;
    int year;

    // Parameterized Constructor
    Car(String make, String model, int year) {

        if (make == null || make.equals("")) {
            this.make = "Unknown";
        } else {
            this.make = make;
        }

        if (model == null || model.equals("")) {
            this.model = "Unknown";
        } else {
            this.model = model;
        }

        if (year <= 0) {
            this.year = 2025;
        } else {
            this.year = year;
        }
    }

    // Print Method
    void print() {
        System.out.println("Make  : " + make);
        System.out.println("Model : " + model);
        System.out.println("Year  : " + year);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        // Creating objects
        Car car1 = new Car("Toyota", "Corolla", 2022);
        Car car2 = new Car("Honda", "Civic", 2021);
        Car car3 = new Car("", "", 0); // Default values will be assigned

        // Printing car information
        System.out.println("Car 1 Information:");
        car1.print();

        System.out.println("Car 2 Information:");
        car2.print();

        System.out.println("Car 3 Information:");
        car3.print();
    }
}