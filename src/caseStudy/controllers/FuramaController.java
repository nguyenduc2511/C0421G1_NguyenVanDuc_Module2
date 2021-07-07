package caseStudy.controllers;

import caseStudy.utils.Choice;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        boolean check = true;
        while (check) {
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management ");
            System.out.println("4. Booking Managerment");
            System.out.println("5. Promotion Management");
            System.out.println("6. Fix Facility Managerment");
            System.out.println("7. Exit");
            System.out.println("choice number ");
            int choice = new Choice().choice();
            switch (choice) {
                case 1:
                    new EmployeeManagerment().employeesMenu();
                    break;
                case 2:
                    new CustomerManagerment().customerMenu();
                    break;
                case 3:
                    new FacilityManagerment().facilityMenu();
                    break;
                case 4:
                    new BookingManagerment().bookingMenu();
                    break;
                case 5:
                    new PromotionManagerment().promotionMenu();
                    break;
                case 6:
                    new WaitFixFacility().waitFixxing();
                    break;
                case 7:
                    check = false;
            }
        }
    }
}
