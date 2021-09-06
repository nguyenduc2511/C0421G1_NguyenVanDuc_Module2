package module2.case_Study.controller;

import caseStudy.utils.Choice;
import module2.case_Study.services.employeeService.EmployeeServiceImpl;

public class EmployeeManagerment_2 {
    public void employeesMenu() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        while (true) {
            System.out.println("1. Display all employees");
            System.out.println("2. Add new employees");
            System.out.println("3. Edit employees");
            System.out.println("4. xoa thong tin theo id ");
            System.out.println("5. Return menu");
            System.out.println("choice number ");
            int choice = new Choice().choice();
            switch (choice) {
                case 1:
                    employeeService.disPlay();
                    break;
                case 2:
                    employeeService.addNew();
                    break;
                case 3:
                    employeeService.editData();
                    break;
                case 4:
                    employeeService.remove();
                    break;
                case 5:
                    return;
            }
        }
    }

}
