package module2.case_Study.services.employeeService;

import caseStudy.models.employee.Employee;
import caseStudy.services.CRUDService;

public interface EmployeeService extends CRUDService<Employee> {
    void remove();
}
