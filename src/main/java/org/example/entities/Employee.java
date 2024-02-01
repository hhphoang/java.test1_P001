package org.example.entities;

public class Employee {
    private String id;
    private String title;
    private String fullName;
    private String workingDomain;
    private String position;
    private double monthlySalary;
    private String departmentId;

    public Employee() {

    }

    public Employee(String id, String title, String fullName, String workingDomain, String position, double monthlySalary, String departmentId) {
        this.id = id;
        this.title = title;
        this.fullName = fullName;
        this.workingDomain = workingDomain;
        this.position = position;
        this.monthlySalary = monthlySalary;
        this.departmentId = departmentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getWorkingDomain() {
        return workingDomain;
    }

    public void setWorkingDomain(String workingDomain) {
        this.workingDomain = workingDomain;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", fullName='" + fullName + '\'' +
                ", workingDomain='" + workingDomain + '\'' +
                ", position='" + position + '\'' +
                ", monthlySalary=" + monthlySalary +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
