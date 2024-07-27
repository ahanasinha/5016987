import java.util.Scanner;

public class EmployeeManagementSystem {

    public static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "employeeId=" + employeeId +
                    ", name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    private static Scanner sc = new Scanner(System.in);
    private static Employee[] employees = new Employee[100];
    private static int employeeCount = 0;

    public static void addEmployee(int id) {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter position: ");
        String position = sc.next();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        employees[employeeCount++] = new Employee(id, name, position, salary);
    }

    public static void searchEmployee(int id) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeId() == id) {
                System.out.println(employees[i]);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public static void traverseEmployees() {
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeId() == id) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employeeCount--;
                System.out.println("Employee with ID " + id + " has been deleted.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public static void main(String[] args) {
        int id = 1;
        while (true) {
            System.out.print("1. Add Employee\n2. Search Employee\n3. Traverse Employees\n4. Delete Employee\n-1 to Exit\nYour choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Employee ID: " + id);
                    addEmployee(id++);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    searchEmployee(searchId);
                    break;
                case 3:
                    traverseEmployees();
                    break;
                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    deleteEmployee(deleteId);
                    break;
                case -1:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Incorrect choice, please try again.");
                    break;
            }
            if (choice == -1) {
                break;
            }
        }
        sc.close();
    }
}
