package module2.case_Study.controller;

import caseStudy.utils.Choice;
import module2.case_Study.services.CustomerService.CustomerServiceImpl;

public class CustomerManagerment_2 {
    public void customerMenu() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        while (true) {
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. xoa customer theo id ");
            System.out.println("5. Return menu");
            int choice= new Choice().choice();
            switch (choice) {
                case 1:
                    customerService.disPlay();
                    break;
                case 2:
                    customerService.addNew();
                    break;
                case 3:
                    customerService.editData();
                    break;
                case 4:
                    customerService.remove();
                    break;
                case 5:
                    return;
            }
        }
    }
}
