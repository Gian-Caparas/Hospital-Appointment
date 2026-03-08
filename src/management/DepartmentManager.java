package management;

import java.util.ArrayList;
import java.util.List;

import models.Department;

public class DepartmentManager {
    
    // Creates List of all Departments and calls it departments
    private List<Department> departments = new ArrayList<>();

    // creates and adds a new department
    public void createDepartment(Department department) {//stores the variable parameter(calls it "department") in the list of departments.
        departments.add(department); //adds the variable("department") to the list of departments
    }

    // returns the list of departments
    public List<Department> getDepartments() {
        return departments;
    }
}
