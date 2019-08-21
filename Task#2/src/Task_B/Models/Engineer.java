package Task_B.Models;

public class Engineer implements Employee {
    private double salary;
    private String position="Engineer";
    private String name;

    public Engineer(double salary, String name) {
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

    public void askAboutWorkProcess(){
        System.out.print("The engineer says that the work is in full swing!");
    }
}
