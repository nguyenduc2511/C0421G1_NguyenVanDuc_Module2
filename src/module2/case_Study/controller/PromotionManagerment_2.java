package module2.case_Study.controller;

import caseStudy.utils.Choice;

public class PromotionManagerment_2 {
    public  void promotionMenu() {
        while (true) {
            System.out.println("1. Display list customers use service");
            System.out.println("2.Display list customers get voucher");
            System.out.println("3. Return menu");
            int choice = new Choice().choice();
            switch (choice) {
                case 1:

//                    code here
                    break;
                case 2:

//                    code here
                    break;
                case 3:
                    return;
            }
        }
    }
}
