package management;

import models.Department;
import java.util.ArrayList;
import java.util.List;

public class DepartmentManager {
    // Creates List of all Departments and calls it departments
    private List<Department> departments;

    public DepartmentManager() {
        this.departments = new ArrayList<>();
    }

    public Department createDepartment(String name) {
        Department dept = new Department(name);
        departments.add(dept);
        return dept;
    }

    // returns the list of departments
    public List<Department> getDepartments() { return departments; }

    public void listDepartments() {
        System.out.println("\n  Available Departments:");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println("  " + (i + 1) + " - " + departments.get(i).getDepartmentName());
        }
    }

    public Department getDepartmentByIndex(int index) {
        if (index >= 0 && index < departments.size()) {
            return departments.get(index);
        }
        return null;
    }
}
