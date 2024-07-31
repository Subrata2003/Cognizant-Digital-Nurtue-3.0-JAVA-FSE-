class Employee {
    String employeeId;
    String name;
    String position;
    double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size] = employee;
            size++;
        }
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId.equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public Employee[] traverseEmployees() {
        Employee[] result = new Employee[size];
        for (int i = 0; i < size; i++) {
            result[i] = employees[i];
        }
        return result;
    }

    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId.equals(employeeId)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                break;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(10);
        Employee e1 = new Employee("1", "Alice", "Manager", 70000.0);
        Employee e2 = new Employee("2", "Bob", "Developer", 50000.0);
        system.addEmployee(e1);
        system.addEmployee(e2);

        System.out.println("Added employees:");
        for (Employee emp : system.traverseEmployees()) {
            System.out.println(emp.name + ": " + emp.position);
        }

        system.deleteEmployee("1");
        System.out.println("After deleting employee 1:");
        for (Employee emp : system.traverseEmployees()) {
            System.out.println(emp.name + ": " + emp.position);
        }
    }
}
