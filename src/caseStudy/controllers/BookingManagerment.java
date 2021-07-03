package caseStudy.controllers;

public class BookingManagerment {
    public void bookingMenu() {
        while (true) {
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new constracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            int choice = new Choice().choice();
            switch (choice) {
                case 1:
                    System.out.println("1. Add new booking");;
//                    code here
                    break;
                case 2:
                    System.out.println("2. Display list booking");
//                    code here
                    break;
                case 3:
                    System.out.println("3. Create new constracts");
//                    code here
                    break;
                case 4:
                    System.out.println("4. Display list contracts");
//                    code here
                    break;
                case 5:
                    System.out.println("5. Edit contracts");
//                    code here
                    break;
                case 6:
                    return;
            }
        }
    }
}
