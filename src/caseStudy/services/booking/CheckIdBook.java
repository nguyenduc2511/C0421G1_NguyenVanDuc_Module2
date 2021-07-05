package caseStudy.services.booking;

import caseStudy.Scan;

import java.util.regex.Pattern;

public class CheckIdBook {
    public boolean idBookingHouse(String id) {
        String regexCheck = "^[B][H][-]\\d{2}$";
        boolean check = false;
        if (Pattern.matches(regexCheck, id)) {
                check=true;
            }
        return check;
    }
    public boolean idBookingRoom(String id) {
        String regexCheck = "^[B][R][-]\\d{2}$";
        boolean check = false;
        if (Pattern.matches(regexCheck, id)) {
                check=true;
            }
        return check;
    }
    public boolean idBookingVilla(String id) {
        String regexCheck = "^[B][V][-]\\d{2}$";
        boolean check = false;
            if (Pattern.matches(regexCheck, id)) {
                check=true;
            }
        return check;
    }
    public String idBooking() {
        String regexCheck1 = "^[B][V][-]\\d{2}$";
        String regexCheck2 = "^[B][R][-]\\d{2}$";
        String regexCheck3 = "^[B][H][-]\\d{2}$";
        String id = null;
        boolean check = false;
        while (!check) {
            System.out.println(" nhap id booking theo đúng định dạng BV-YY; vd BV-01; BH-01; BR-01");
            id = new Scan().input().nextLine();
            if (Pattern.matches(regexCheck1, id)) {
                check=true;
            }else if (Pattern.matches(regexCheck2, id)) {
                check = true;
            }else if (Pattern.matches(regexCheck3, id)) {
                check = true;
            }
        }
        return id;
    }
}