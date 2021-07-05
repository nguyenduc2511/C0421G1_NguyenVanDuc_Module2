package caseStudy.models.bookingAndContract;

import caseStudy.Scan;

import java.util.regex.Pattern;

public class  checkDate {
    public String checkDateBooking() {
        String regexCheck = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
        String dateBooking = null;
        boolean check = false;
        while (!check) {
            System.out.println(" nhap ngay booking của bạn theo đúng định dạng dd/MM/yyyy; vd 11/11/2021");
            dateBooking = new Scan().input().nextLine();
            if (Pattern.matches(regexCheck, dateBooking)) {
                check = true;
            }
        }
        return dateBooking;
    }
}
