package caseStudy.controllers;

import caseStudy.services.employeeService.EmployeeServiceImpl;

public class EmployeeManagerment {
    public void employeesMenu() {
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
                    System.out.println("1. Display all employees");
                    new EmployeeServiceImpl().disPlay();
                    break;
                case 2:
                    System.out.println("2. Add new employees");
                    new EmployeeServiceImpl().addNew();
                    break;
                case 3:
                    System.out.println("3. Edit employees");
                    new EmployeeServiceImpl().editData();
                    break;
                case 4:
                    System.out.println("4. xoa thong tin theo id ");
                    new EmployeeServiceImpl().remove();
                    break;
                case 5:
                    return;
            }
        }
    }

}