import java.util.*;

public class Company {
    private Set<Employee> employees = new HashSet<>();
    private int totalSalaries = 0;

    public Company(){
        employees = new HashSet<>();
    }

    public Set<Employee> getEmployees(){
        return employees;
    }
    public int getTotalSalaries(){
        return totalSalaries;
    }

    public Employee getEmployee(int ID) {
        for(Employee emp:employees){
            if(emp.getID() == ID){
                return emp;
            }
        }
        return null;
    }

   public boolean addEmployee(Employee emp){
       if(getEmployee(emp.getID()) != null){
           return false; //prevent overwriting an existing employee (salary will mess up)
       }
       employees.add(emp);
       totalSalaries+=emp.getSalary();
       return true;
   }
   public boolean removeEmployee(Employee emp){
       if(!employees.contains(emp)){
           return false;
       }
       employees.remove(emp);
       totalSalaries-=emp.getSalary();
       return true;
   }
   public List<Employee> sortByDepartment() { //using streams and inline comparator
         return employees.stream()
                 .sorted(Comparator.comparing(Employee::getDepartment))
                 .toList();
   }


}