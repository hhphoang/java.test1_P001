package org.example.service;

import org.example.entities.Department;
import org.example.entities.Employee;
import org.example.utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeService {

    static Scanner scanner = new Scanner(System.in);
    private List<Employee> employees = new ArrayList<>();

    List<String> ids = new ArrayList<>();

    private final DepartmentService departmentService;

    public EmployeeService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void creatEmployee() {
        System.out.print("Enter employee ID: ");
        String employeeId = getEmployeeId();
        System.out.print("Enter employee title (Mr/Mrs/Ms): ");
        String employeeTitle = getEmployeeTitle();
        System.out.print("Enter employee full name: ");
        String employeeFullName = scanner.nextLine();
        System.out.print("Enter employee working domain: ");
        String employeeWorkingDomain = departmentService.getDomain();
        System.out.print("Enter employee position: ");
        String employeePosition = departmentService.getString("employee position");
        System.out.print("Enter employee monthly salary: ");
        double employeeMonthlySalary = getDouble();
        System.out.print("Enter department ID: ");
        String departmentId = scanner.nextLine().trim();
        Employee employee = new Employee(employeeId, employeeTitle, employeeFullName, employeeWorkingDomain, employeePosition, employeeMonthlySalary, departmentId);
        addEmployee(employee);
    }

    public void addEmployee(Employee e) {
        employees.add(e);
        if (!isIdExit(e.getId())) {
            ids.add(e.getId());
        }
    }

    public List<String> getIds() {
        return ids;
    }

    public void saveEmployee() {
        FileManager fileManager = new FileManager();
        fileManager.save(getEmployeeToString(), "employee.dat", "employee");
    }

    private List<String> getEmployeeToString() {
        return employees.stream().map(Employee::toString).collect(Collectors.toList());
    }

    public void addEmployeeToDepartment(String employeeId, String departmentId) {
        Employee employee = getEmployeeById(employeeId);
        Department department = departmentService.getDepartmentById(departmentId);
        if (employee != null && department != null) {
            if (employee.getWorkingDomain().equalsIgnoreCase(department.getDomain())) {
                employee.setDepartmentId(departmentId);
                System.out.println("Add employee successfully!");
            } else {
                System.out.println("Employee must be in the same domain with department!");
            }
        }
        else {
        System.out.println("Not found employee or department!");}
    }

    public void removeEmployeeFromDepartment(String employeeId) {
        Employee employee = getEmployeeById(employeeId);
        System.out.println(employee);
        if (employee != null) {
            employee.setDepartmentId(null);
            System.out.println("Remove successfully!");
        } else {
            System.out.println("Not found any employee to remove");
        }
    }

    public void displayEmployeesWithDepartmentId() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName() + " - Department ID: " + employee.getDepartmentId());
        }
    }

    private Employee getEmployeeById(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public String getEmployeeId() {
        String id;
        do {
            id = scanner.nextLine().trim();
            if (Validator.validateId(id, "employee")) {
                if (!isIdExit(id)) {
                    ids.add(id);
                    break;
                } else {
                    System.out.print("id have exit. Please re-enter new id: ");
                }
            } else {
                System.out.print("Invalid value. Please re-enter id:  ");
            }
        } while (true);
        return id;
    }

    public String getEmployeeIdToSearch() {
        String id;
        do {
            id = scanner.nextLine().trim();
            if (Validator.validateId(id, "employee")) {
                if (isIdExit(id)) {
                    break;
                } else {
                    System.out.print("not found employee id. Please re-enter: ");
                }
            } else {
                System.out.print("Invalid value. Please re-enter id:  ");
            }
        } while (true);
        return id;
    }

    public String getEmployeeTitle() {
        String title;
        do {
            title = scanner.nextLine().trim();
            if (Validator.validateTitleEmployee(title)) break;
            else {
                System.out.print("Invalid value. Please re-enter title:  ");
            }
        } while (true);
        return title;
    }

    public String getDepartmentIds() {
        String departId;
        do {
            departId = scanner.nextLine().trim();
            if (departmentService.getDepartmentIds().contains(departId)) break;
            else {
                System.out.print("Department id not exit, please re-enter :  ");
            }
        } while (true);
        return departId;
    }

    public double getDouble() {
        double value;
        do {
            try {
                value = Double.parseDouble(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Invalid value, please re-enter value: ");
            }
        } while (true);
        return value;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean isIdExit(String id) {
        return ids.contains(id);
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
