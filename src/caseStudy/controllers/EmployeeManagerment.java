package caseStudy.controllers;

import caseStudy.utils.Choice;

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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    return;
            }
        }
    }

}
