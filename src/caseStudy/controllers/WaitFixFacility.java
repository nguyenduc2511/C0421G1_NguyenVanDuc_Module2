package caseStudy.controllers;

import caseStudy.services.facility.HouseServiceImpl;
import caseStudy.services.facility.RoomServiceImpl;
import caseStudy.services.facility.VillaServiceImpl;

public class WaitFixFacility {
    public void waitFixxing() {
        while (true) {
            System.out.println("1. hien thi danh sach các danh mục cần sửa ");
            System.out.println("2. tiến hành sửa ");
            System.out.println("3. Return main menu ");
            System.out.println("nhap lua chon ");
            int choice = new Choice().choice();
            switch (choice) {
                case 1: {
                    System.out.println("1. hien thi danh sach các danh mục cần sửa ");
                    new HouseServiceImpl().displayFixData();
                    System.out.println("\n");
                    new RoomServiceImpl().displayFixData();
                    System.out.println("\n");
                    new VillaServiceImpl().displayFixData();
                }
                case 2: {
                    boolean check = true;
                    while (check) {
                        System.out.println("ban muon sua danh muc nao ");
                        System.out.println("1. fix House ");
                        System.out.println("2. fix Room ");
                        System.out.println("3. fix Villa ");
                        System.out.println("4. thoat sua  ");
                        System.out.println("nhap lua chon ");
                        int choice2 = new Choice().choice();
                        switch (choice2){
                            case 1:{
                                new HouseServiceImpl().displayFixData();
                                new HouseServiceImpl().fixData();
                                System.out.println("1. fix House complete ");
                                break;
                            }
                            case 2:{
                                new RoomServiceImpl().displayFixData();
                                new RoomServiceImpl().fixData();
                                System.out.println("2. fix Room complete ");
                            }
                            case 3:{
                                new VillaServiceImpl().displayFixData();
                                new VillaServiceImpl().fixData();
                                System.out.println("3. fix Villa Complete");
                            }
                            case 4:{
                                check=false;
                                break;
                            }
                            default:break;
                        }
                    }
                }
                case 3:{
                    return;
                }
                default:break;
            }
        }
    }
}
