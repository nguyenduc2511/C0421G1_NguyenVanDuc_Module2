package caseStudy.controllers;

import java.util.Scanner;

public class FuramaController {
    public static Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        boolean check = true;
        while (check) {
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management ");
            System.out.println("4. Booking Managerment");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            switch (choice) {
                case 1:
                    employeesMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    facilityMenu();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    check = false;
            }
        }
    }

    private void employeesMenu() {
        while (true) {
            System.out.println("1. Display all employees");
            System.out.println("2. Add new employees");
            System.out.println("3. Edit employees");
            System.out.println("4. Return menu");
            int choiceSecond = Integer.parseInt(scanner.nextLine());
            switch (choiceSecond) {
                case 1:
                    System.out.println("1. Display all employees");
                    break;
                case 2:
                    System.out.println("2. Add new employees");
                    break;
                case 3:
                    System.out.println("3. Edit employees");
                    break;
                case 4:
                    return;
            }
        }
    }

    private void customerMenu() {
        while (true) {
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return menu");
            int choiceSecond = Integer.parseInt(scanner.nextLine());
            switch (choiceSecond) {
                case 1:
                    System.out.println("1. Display list customers");
                    break;
                case 2:
                    System.out.println("2. Add new customer");
                    break;
                case 3:
                    System.out.println("3. Edit customer");
                    break;
                case 4:
                    return;
            }
        }
    }

    private void facilityMenu() {
        while (true) {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3.Display facility maintenance");
            System.out.println("4. Return menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("1. Display list facility");
//                    code here
                    break;
                case 2:
                    System.out.println("2. Add new facility");
//                    code here
                    break;
                case 3:
                    System.out.println("3.Display facility maintenance");
//                    code here
                    break;
                case 4:
                    return;
            }
        }
    }
}
