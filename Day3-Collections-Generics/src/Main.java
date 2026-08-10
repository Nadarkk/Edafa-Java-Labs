//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Employee e1 = new Employee(8, "Alice", "HR", 50000);
    Employee e2 = new Employee(5, "Bob", "IT", 60000);
    Employee e3 = new Employee(3, "Charlie", "Finance", 55000);
    Employee e4 = new Employee(1, "David", "Marketing", 52000);
    Employee e5 = new Employee(2, "Eve", "Sales", 58000);
    Employee e6 = new Employee(4, "Frank", "IT", 62000);
    Employee e7 = new Employee(4, "Grace", "Finance", 54000);
    Employee e8 = new Employee(6, "Hannah", "HR", 100000);
    Employee e9 = new Employee(7, "Ian", "Marketing", 70000);

    Company company = new Company();
    System.out.println("Total salaries at first: " + company.getTotalSalaries());
    company.addEmployee(e1);
    company.addEmployee(e2);
    company.addEmployee(e3);
    company.addEmployee(e4);
    System.out.println("\n Total of 4 salaries: " + company.getTotalSalaries());
    company.addEmployee(e5);
    company.addEmployee(e6);
    company.addEmployee(e7);
    company.addEmployee(e8);
    company.addEmployee(e9);
    System.out.println("\n Total of all salaries: " + company.getTotalSalaries());

    System.out.println("\n Employees sorted by department:");
    company.sortByDepartment().forEach(emp -> emp.displayInfo()); //testing streams

    System.out.println("\n Employees sorted by Salaries ascending:");
    Comparator comp = new sortBySalaryComparator();
    List<Employee> sortedEmployees = new ArrayList<>(company.getEmployees());
    Collections.sort(sortedEmployees, comp);
    for(Employee emp: sortedEmployees){
        emp.displayInfo();
    }


    System.out.println("\n Top 5 employees salaries");

    Collections.sort(sortedEmployees, comp.reversed());
    sortedEmployees.stream().limit(5).forEach(emp-> emp.displayInfo());
}
