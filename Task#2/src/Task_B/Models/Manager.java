package Task_B.Models;

public class Manager implements Employee {

    private double salary;
    private String position="Manager";
    private String name;

    public Manager(double salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary=salary;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return name;
    }
}
