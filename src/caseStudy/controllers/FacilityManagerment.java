package caseStudy.controllers;

import caseStudy.services.facility.FacilityServiceImpl;
import caseStudy.utils.Choice;

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
                    new FacilityServiceImpl().disPlay();
//                    code here
                    break;
                case 2:
                    new FacilityServiceImpl().editData();
//                    code here
                    break;
                case 3:
//                    code here
                    new FacilityServiceImpl().addNew();
                    break;
                case 4:
                    new FacilityServiceImpl().displayFixData();
                    break;
                case 5:
                    return;
            }
        }
    }
}
