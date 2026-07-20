package employees;

public class FullTimeEmployee implements Employee {
    protected String name;
    protected String position;
    protected double salary;

    public FullTimeEmployee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeDetails() {
        return "Employee Details:\n" +
               "Name: " + name + "\n" +
               "Position: " + position + "\n" +
               "Salary: $" + String.format("%.2f", salary);
    }

    public void performTask() {
        System.out.println(name + " is performing their regular duties.");
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}