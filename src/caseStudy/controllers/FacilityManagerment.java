package caseStudy.controllers;

public class FacilityManagerment {
    public void facilityMenu() {
        while (true) {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3.Display facility maintenance");
            System.out.println("4. Return menu");
            int choice = new Choice().choice();
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
