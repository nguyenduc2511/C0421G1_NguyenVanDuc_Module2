package caseStudy.controllers;

public class PromotionManagerment {
    public  void promotionMenu() {
        while (true) {
            System.out.println("1. Display list customers use service");
            System.out.println("2.Display list customers get voucher");
            System.out.println("3. Return menu");
            int choice = new Choice().choice();
            switch (choice) {
                case 1:
                    System.out.println("1. Display list customers use service");
//                    code here
                    break;
                case 2:
                    System.out.println("2.Display list customers get voucher");
//                    code here
                    break;
                case 3:
                    return;
            }
        }
    }
}
