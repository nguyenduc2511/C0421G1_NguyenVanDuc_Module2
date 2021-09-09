package module2.case_Study.controller;


import module2.case_Study.services.facility.FacilityServiceImpl;
import module2.case_Study.utils.Choice;

public class FacilityManagerment_2 {
    public void facilityMenu() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        while (true) {
            System.out.println("1. Display list facility");
            System.out.println("2. edit list facility");
            System.out.println("3. Add new facility");
            System.out.println("4. Return menu");
            int choice = new Choice().choice();
            switch (choice) {
                case 1:
                    facilityService.disPlay();
//                    code here
                    break;
                case 2:
                    facilityService.editData();
//                    code here
                    break;
                case 3:
//                    code here
                    facilityService.addNew();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("nhap dung lua chon");
                    break;
            }
        }
    }
}
