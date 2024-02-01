package org.example.main;

import org.example.entities.Department;
import org.example.entities.Employee;
import org.example.service.DepartmentService;
import org.example.service.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class Test {
    static DepartmentService departmentService = new DepartmentService();

    static EmployeeService employeeService = new EmployeeService(departmentService);

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //input department
        Department department1 = new Department("DE35678", "de1", "FIN");
        Department department2 = new Department("DE42789", "de2", "MAR");
        Department department3 = new Department("DE78120", "de3", "HRM");
        departmentService.addDepartment(department1);
        departmentService.addDepartment(department2);
        departmentService.addDepartment(department3);

        //input employees
        Employee employee1 = new Employee("EM12345", "Mr", "Lalaland", "FIN", "manager", 2000, null);
        Employee employee2 = new Employee("EM23456", "Ms", "Chimom", "MAR", "leader", 5000, "DE42789");
        Employee employee3 = new Employee("EM34567", "Mrs", "Dunk", "ADM", "admin", 8000, null);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        employeeService.addEmployee(employee3);

        while (true) {
            printLine();
            showMainScreen();
            String userInput = scanner.nextLine().trim();
            String userChoice;
            switch (userInput) {
                case "1":
                    printLine();
                    System.out.println("Department Management");
                    System.out.println("1. Add new department");
                    System.out.println("2. Search departments");
                    System.out.print("Choose your choice: ");
                    userChoice = scanner.nextLine().trim();
                    switch (userChoice) {
                        case "1":
                            departmentService.createDepartment();
                            System.out.println("Add a new department successfully!");
                            break;
                        case "2":
                            System.out.print("Enter department name: ");
                            String searchByDepartmentName = departmentService.getString("department name");
                            Department department = departmentService.searchDepartmentByName(searchByDepartmentName);
                            if (department != null) {
                                System.out.println(department);
                            } else {
                                System.out.println("Department not found.");
                            }
                            break;
                        default:
                            System.out.println("Invalid option!");
                    }
                    break;
                case "2":
                    System.out.println("2. Employee Management");
                    printLine();
                    System.out.println("1. Add new employee");
                    System.out.println("2. Add employee to department");
                    System.out.println("3. Display List of Employee");
                    System.out.println("4. Remove the Employee from department");
                    System.out.print("Choose your choice: ");
                    userChoice = scanner.nextLine().trim();
                    switch (userChoice) {
                        case "1":
                            employeeService.creatEmployee();
                            System.out.println("Add a new employee successfully!");
                            break;
                        case "2":
                            System.out.print("Enter employee ID: ");
                            String employeeId = employeeService.getEmployeeIdToSearch();
                            System.out.print("Enter department ID: ");
                            String departmentId = departmentService.getDepartmentIdToSearch();
                            employeeService.addEmployeeToDepartment(employeeId, departmentId);
                            break;
                        case"3":
                            employeeService.displayEmployeesWithDepartmentId();
                            break;
                        case"4":
                            System.out.print("Enter employee ID: ");
                            String EmId = employeeService.getEmployeeIdToSearch();
                            employeeService.removeEmployeeFromDepartment(EmId);
                            break;
                        default:
                            System.out.println("Invalid option!");
                    }
                    break;
                case "3":
                    scanner.close();
                    departmentService.saveDepartment();
                    employeeService.saveEmployee();
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public static void printLine() {
        System.out.println("---------------------------------------------------------------------");
    }
    private static void showMainScreen() {
        System.out.println("1. Department Management");
        System.out.println("2. Employee Management");
        System.out.println("3. Exit the program");
        System.out.print("Choose function: ");
    }


}
