import java.util.*;

public class sortBySalaryComparator implements Comparator<Employee>{
    public int compare(Employee e1, Employee e2){
        return Integer.compare(e1.getSalary(), e2.getSalary()); //sort asc
    }
}
