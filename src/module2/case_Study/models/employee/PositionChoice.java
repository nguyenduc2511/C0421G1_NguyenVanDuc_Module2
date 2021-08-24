package module2.case_Study.models.employee;

import caseStudy.utils.Choice;

public class PositionChoice {
    public String positionChoicee() {
        String a = null;
        boolean check = true;
        while (check) {
            System.out.println(" 1: le tan \n 2: phucvu \n 3:chuyen vien \n 4:giam sat \n 5: quan ly \n 6: giam doc");
            System.out.println("chon chuc vu");
            int choice = new Choice().choice();
            switch (choice) {
                case 1: {
                    a = "Lễ tân";
                    check = false;
                    break;
                }
                case 2: {
                    a = "phục vụ";
                    check = false;
                    break;
                }
                case 3: {
                    a = "chuyên viên";
                    check = false;
                    break;
                }
                case 4: {
                    a = "giám sát";
                    check = false;
                    break;
                }
                case 5: {
                    a = "quản lý";
                    check = false;
                    break;
                }
                case 6: {
                    a = "giám đốc";
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
