package employees;

import managers.Manager;

public class ProjectManager extends FullTimeEmployee implements Manager {
    private String department;

    public ProjectManager(String name, String position, double salary, String department) {
        super(name, position, salary);
        this.department = department;
    }

   
    public void assignTask(String task) {
        System.out.println("Project Manager " + name + " from " + department + 
                           " department assigned task: " + task);
    }

    public void performTask() {
        System.out.println(name + " is managing the " + department + " department and assigning tasks.");
    }

    @Override
    public String getEmployeeDetails() {
        return super.getEmployeeDetails() + "\n" +
               "Department: " + department;
    }

    public String getDepartment() {
        return department;
    }
}