package caseStudy.services.booking;

import caseStudy.Scan;

import java.util.regex.Pattern;

public class CheckIdBook {
    public String idBookingHouse() {
        String regexCheck = "^[B][H][-]\\d{2}$";
        String id = null;
        boolean check = false;
        while (!check) {
            System.out.println(" nhap id booking theo đúng định dạng BH-YY; vd BH-01");
            id = new Scan().input().nextLine();
            if (Pattern.matches(regexCheck, id)) {
                check=true;
            }
        }
        return id;
    }
    public String idBookingRoom() {
        String regexCheck = "^[B][R][-]\\d{2}$";
        String id = null;
        boolean check = false;
        while (!check) {
            System.out.println(" nhap id booking theo đúng định dạng BR-YY; vd BR-01");
            id = new Scan().input().nextLine();
            if (Pattern.matches(regexCheck, id)) {
                check=true;
            }
        }
        return id;
    }
    public String idBookingVilla() {
        String regexCheck = "^[B][V][-]\\d{2}$";
        String id = null;
        boolean check = false;
        while (!check) {
            System.out.println(" nhap id booking theo đúng định dạng BV-YY; vd BV-01");
            id = new Scan().input().nextLine();
            if (Pattern.matches(regexCheck, id)) {
                check=true;
            }
        }
        return id;
    }
}