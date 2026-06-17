package Employee;

class Employee {
    protected String name;
    protected double basicSalary;

    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }
}

class Lecturer extends Employee {
    private double researchAllowance;

    public Lecturer(String name, double basicSalary, double researchAllowance) {
        super(name, basicSalary);
        this.researchAllowance = researchAllowance;
    }

    public double calculateSalary() {
        return basicSalary + researchAllowance;
    }
}

class LabAssistant extends Employee {
    private double overtimePayment;

    public LabAssistant(String name, double basicSalary, double overtimePayment) {
        super(name, basicSalary);
        this.overtimePayment = overtimePayment;
    }

    public double calculateSalary() {
        return basicSalary + overtimePayment;
    }
}