package Task_B.Models;

public class Janitor implements Employee {
    private double salary;
    private String position="Janitor";
    private String name;

    public Janitor(double salary, String name) {
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

    public void callingJanitor(){
        System.out.println("The janitor was called");
    }
}
