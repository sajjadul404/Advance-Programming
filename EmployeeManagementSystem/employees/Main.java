import employees.FullTimeEmployee;
import managers.ProjectManager;

public class Main {
    public static void main(String[] args) {

        FullTimeEmployee employee = new FullTimeEmployee(
            "John Smith", 
            "Software Developer", 
            75000.00
        );

        ProjectManager manager = new ProjectManager(
            "Sarah Johnson",
            "Senior Project Manager",
            95000.00,
            "IT"
        );

        System.out.println("=== EMPLOYEE MANAGEMENT SYSTEM ===\n");

        System.out.println("1. Full-Time Employee Details:");
        System.out.println("-------------------------------");
        System.out.println(employee.getEmployeeDetails());
        System.out.println();
        
        System.out.println("2. Employee Performing Task:");
        System.out.println("-------------------------------");
        employee.performTask();
        System.out.println();

        System.out.println("3. Project Manager Details:");
        System.out.println("-------------------------------");
        System.out.println(manager.getEmployeeDetails());
        System.out.println();

        System.out.println("4. Project Manager Assigning Tasks:");
        System.out.println("-------------------------------");
        manager.assignTask("Develop the new customer portal");
        manager.assignTask("Implement payment gateway integration");
        System.out.println();

        System.out.println("5. Project Manager Performing Task:");
        System.out.println("-------------------------------");
        manager.performTask();
        System.out.println();

        System.out.println("6. Demonstration of Inheritance:");
        System.out.println("-------------------------------");
        System.out.println("ProjectManager inherited from FullTimeEmployee:");
        System.out.println("- Name: " + manager.getName());
        System.out.println("- Position: " + manager.getPosition());
        System.out.println("- Salary: $" + String.format("%.2f", manager.getSalary()));
        System.out.println("- Department: " + manager.getDepartment());
    }
}