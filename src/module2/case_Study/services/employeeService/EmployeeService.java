package module2.case_Study.services.employeeService;


import module2.case_Study.models.employee.Employee;
import module2.case_Study.services.CRUDService;

public interface EmployeeService extends CRUDService<Employee> {
    void remove();
}
