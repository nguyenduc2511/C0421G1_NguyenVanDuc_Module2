package caseStudy.models.Customer;

import caseStudy.utils.Choice;

import java.io.Serializable;

public class TypeCustomer implements Serializable {
    public String choiCustomer() {
        String a = null;
        boolean check = true;
        while (check) {
            System.out.println(" 1: diamond \n 2: Platinium \n 3: Gold \n 4: Silver \n 5:Member");
            System.out.println("your choice = ");
            int choice = new Choice().choice();
            switch (choice) {
                case 1: {
                    a = "Diamond";
                    check = false;
                    break;
                }
                case 2: {
                    a = "Platinium";
                    check = false;
                    break;
                }
                case 3: {
                    a = "Gold";
                    check = false;
                    break;
                }
                case 4: {
                    a = "Silver";
                    check = false;
                    break;
                }
                case 5: {
                    a = "Member";
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
