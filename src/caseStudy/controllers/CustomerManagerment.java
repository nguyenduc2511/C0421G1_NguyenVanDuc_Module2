package caseStudy.controllers;

import caseStudy.services.CustomerService.CustomverServiceImpl;

public class CustomerManagerment {
    public void customerMenu() {
        while (true) {
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. xoa customer theo id ");
            System.out.println("5. Return menu");
            int choice= new Choice().choice();
            switch (choice) {
                case 1:
                    System.out.println("1. Display list customers");
                    new CustomverServiceImpl().disPlay();
                    break;
                case 2:
                    System.out.println("2. Add new customer");
                    new CustomverServiceImpl().addNew();
                    break;
                case 3:
                    System.out.println("3. Edit customer");
                    new CustomverServiceImpl().editData();
                    break;
                case 4:
                    System.out.println("4. xoa customer theo id ");
                    new CustomverServiceImpl().remove();
                    break;
                case 5:
                    return;
            }
        }
    }
}
