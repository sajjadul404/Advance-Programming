package Employee;


public class Main {
    public static void main(String[] args) {

        Employee emp1 = new Lecturer("Dr. Rahman", 50000, 10000);
        Employee emp2 = new LabAssistant("Karim", 30000, 5000);

        System.out.println("Employee Name: " + emp1.name);
        System.out.println("Final Salary: " + emp1.calculateSalary());

        System.out.println();

        System.out.println("Employee Name: " + emp2.name);
        System.out.println("Final Salary: " + emp2.calculateSalary());
    }
}