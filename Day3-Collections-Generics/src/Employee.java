import java.util.*;
public class Employee implements Comparable<Employee> {
    private final int ID;
    private final String Name;
    private String Department;
    private int Salary;

    public Employee(int ID, String Name, String Department, int Salary){
        this.ID = ID;
        this.Name = Name;
        this.Department = Department;
        this.Salary = Salary;
    }

    //sort IDs by Comparable
    public int compareTo(Employee other) {
        return Integer.compare(this.ID, other.ID);
    }

    public int getID() {
        return ID;
    }
    public String getName() {
        return Name;
    }
    public String getDepartment(){
        return Department;
    }
    public int getSalary(){
        return Salary;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }
    public void setSalary(int Salary) {
        this.Salary = Salary;
    }
    public void displayInfo(){
        System.out.println("ID: " + ID + ", Name: " + Name + ", Department: " + Department + ", Salary: " + Salary);
    }

}