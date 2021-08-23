package module2.case_Study.controller;

import caseStudy.utils.Choice;

public class FacilityManagerment_2 {
    public void facilityMenu() {
        while (true) {
            System.out.println("1. Display list facility");
            System.out.println("2. edit list facility");
            System.out.println("3. Add new facility");
            System.out.println("4. Return menu");
            int choice = new Choice().choice();
            switch (choice) {
                case 1:

//                    code here
                    break;
                case 2:

//                    code here
                    break;
                case 3:
//                    code here

                    break;
                case 4:
                    return;
            }
        }
    }
}
