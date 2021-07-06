package caseStudy.models.employee;

import caseStudy.utils.Choice;

public class AcademicLevel {
    public String choiceLevel() {

        String a = null;
        boolean check = true;
        while (check) {
            System.out.println(" 1:Trung cấp \n 2: Cao đẳng \n 3: Đại học \n 4: Sau đại học ");
            System.out.println("chon bằng cấp");
            int choice = new Choice().choice();
            switch (choice) {
                case 1: {
                    a = "Trung Cap";
                    check = false;
                    break;
                }
                case 2: {
                    a = "Cao Dang";
                    check = false;
                    break;
                }
                case 3: {
                    a = "Dai hoc";
                    check = false;
                    break;
                }
                case 4: {
                    a = "Sau Dai hoc";
                    check = false;
                    break;
                }
                default:
                   break;
            }
        }
        return a;
    }
}
