package caseStudy.controllers;

import caseStudy.services.booking.BookingServiceImpl;
import caseStudy.services.booking.ContactServiceImpl;
import caseStudy.utils.Choice;

public class BookingManagerment {
    public void bookingMenu() {
        while (true) {
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking waitting constracts");
            System.out.println("3. Create new constracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            int choice = new Choice().choice();
            switch (choice) {
                case 1:
                    new BookingServiceImpl().addNew();
//                    code here
                    break;
                case 2:
                    new BookingServiceImpl().disPlay();
//                    code here
                    break;
                case 3:
                    new ContactServiceImpl().addNew();
//                    code here
                    break;
                case 4:
                    new ContactServiceImpl().disPlay();
//                    code here
                    break;
                case 5:
                    new ContactServiceImpl().editData();
//                    code here
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }
}
