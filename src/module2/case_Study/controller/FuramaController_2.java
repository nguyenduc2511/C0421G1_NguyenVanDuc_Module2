package module2.case_Study.controller;

import caseStudy.utils.Choice;

public class FuramaController_2 {

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
                    new EmployeeManagerment_2().employeesMenu();
                    break;
                case 2:
                    new CustomerManagerment_2().customerMenu();
                    break;
                case 3:
                    new FacilityManagerment_2().facilityMenu();
                    break;
                case 4:
                    new BookingManagerment_2().bookingMenu();
                    break;
                case 5:
                    new PromotionManagerment_2().promotionMenu();
                    break;
                case 6:

                    break;
                case 7:
                    check = false;
                default:
                    System.out.println("hay nhap lua chon dung");
                    break;
            }
        }
    }
}
