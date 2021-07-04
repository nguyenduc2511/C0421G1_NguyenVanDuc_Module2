package caseStudy.controllers;

import caseStudy.services.facility.FacilityServiceImpl;

public class FacilityManagerment {
    public void facilityMenu() {
        while (true) {
            System.out.println("1. Display list facility");
            System.out.println("2. edit list facility");
            System.out.println("3. Add new facility");
            System.out.println("4.Display facility maintenance");
            System.out.println("5. Return menu");
            int choice = new Choice().choice();
            switch (choice) {
                case 1:
                    System.out.println("1. Display list facility");
                    new FacilityServiceImpl().disPlay();
//                    code here
                    break;
                case 2:
                    System.out.println("2. edit facility");
                    new FacilityServiceImpl().editData();
//                    code here
                    break;
                case 3:
                    System.out.println("3.add new maintenance");
//                    code here
                    new FacilityServiceImpl().addNew();
                    break;
                case 4:
                    System.out.println("4.Display facility maintenance");
                    new FacilityServiceImpl().displayFixData();
                    break;
                case 5:
                    return;
            }
        }
    }
}
