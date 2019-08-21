package Task_B.Models;

/*
 * Employee interface
 */
public interface Employee {
    double getSalary();               // Returns the value of an employee's salary
    void setSalary(double salary);    // Sets the value of an employee's salary
    String getPosition();             // Returns the position of the employee
    String getName();                 // Returns the name of the employee
}
