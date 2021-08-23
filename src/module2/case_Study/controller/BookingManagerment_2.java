package module2.case_Study.controller;

import caseStudy.utils.Choice;

public class BookingManagerment_2 {
    public void bookingMenu() {
        while (true) {
            System.out.println("1. Add new booking");
            System.out.println("2. edit booking");
            System.out.println("3. Display list booking waitting constracts");
            System.out.println("4. Create new constracts");
            System.out.println("5. Display list contracts");
            System.out.println("6. Edit contracts");
            System.out.println("7. Return main menu");
            int choice = new Choice().choice();
            switch (choice) {
                case 1:

                    break;
                case 2:

//                    code here
                    break;
                case 3:

//                    code here
                    break;
                case 4:

//                    code here
                    break;
                case 5:

//                    code here
                    break;
                case 6:

//                    code here
                    break;
                case 7:
                    return;
                default:
                    break;
            }
        }
    }
}
