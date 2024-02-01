package org.example.service;

import org.example.entities.Department;
import org.example.utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DepartmentService {
    public List<Department> departments = new ArrayList<>();

    private final List<String> ids = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);


    public DepartmentService() {
    }

    public void addDepartment( Department d) {
        departments.add(d);
        if (!ids.contains(d.getId())) {
            ids.add(d.getId());
        }
    }
    public Department searchDepartmentByName(String name) {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }

    public Department getDepartmentById(String id) {
        for (Department department : departments) {
            if (department.getId().equals(id)) {
                return department;
            }
        }
        return null;
    }

    public void createDepartment() {
        System.out.print("Enter department ID: ");
        String departmentId = getDepartmentId();
        System.out.print("Enter department name: ");
        String departmentName = getString("department name");
        System.out.print("Enter department domain: ");
        String departmentDomain = getDomain();
        Department department = new Department(departmentId, departmentName, departmentDomain);
        addDepartment(department);
    }

    public String getDepartmentId() {
        String id;
        do {
            id = scanner.nextLine().trim();
            if (Validator.validateId(id, "department")) {
                if (!isIdExit(id)) {
                    ids.add(id);
                    break;
                }
                else {
                    System.out.print("id have exit. Please re-enter new id: ");
                }
            } else {
                System.out.print("Invalid value. Please re-enter id:  ");
            }
        } while (true);
        return id;
    }

    public String getDepartmentIdToSearch() {
        String id;
        do {
            id = scanner.nextLine().trim();
            if (Validator.validateId(id, "department")) {
                if (isIdExit(id)) {
                    break;
                }
                else {
                    System.out.print("Not found the department id. Please re-enter: ");
                }
            } else {
                System.out.print("Invalid value. Please re-enter id:  ");
            }
        } while (true);
        return id;
    }

    public boolean isIdExit(String id) {
        return ids.contains(id);
    }

    public String getDomain() {
        String domain;
        do {
            domain = scanner.nextLine().trim();
            if (Validator.validateDomain(domain)) break;
            else {
                System.out.print("Invalid value. Please re-enter domain:  ");
            }
        } while (true);
        return domain;
    }

    public List<String> getDepartmentToString() {
        return departments.stream().map(Department::toString).collect(Collectors.toList());
    }
    public List<Department> getDepartments() {
        return departments;
    }

    public void saveDepartment() {
        FileManager fileManager = new FileManager();
        fileManager.save(getDepartmentToString(),"department.dat","department");
    }

    public String getString(String attribute) {
        String input;
        do {
            input = scanner.nextLine().trim();
            if (Validator.isStringNotNull(input)) break;
            else {
                System.out.print("Please re-enter " + attribute + ": ");
            }
        } while (true);
        return input;
    }

    public List<String> getDepartmentIds() {
        return ids;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
