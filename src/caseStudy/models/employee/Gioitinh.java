package caseStudy.models.employee;

import caseStudy.controllers.Choice;

public class Gioitinh {
    public String gender() {
        String a = null;
        boolean check = true;
        while (check) {
            System.out.println(" 1: gioi tinh nam \n 2: gioi tinh nu \n 3: LGPT");
            System.out.println("chon gio tinh ");
            int choice = new Choice().choice();
            switch (choice) {
                case 1: {
                    a = " male";
                    check = false;
                    break;
                }
                case 2: {
                    a = "female";
                    check = false;
                    break;
                }
                case 3: {
                    a = "LGPT";
                    check = false;
                    break;
                }
                default: break;
            }
        }
        return a;
    }
}
