package caseStudy.services.booking;

import caseStudy.Scan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class CheckDatebooking {
    public String checkDateBookingStart() {
        String regexCheck = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
        String dateBooking = null;
        boolean check = false;
        while (!check) {
            System.out.println(" nhap ngay booking của bạn theo đúng định dạng dd/MM/yyyy; vd 11/11/2021");
            dateBooking = new Scan().input().nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate starBook = LocalDate.parse(dateBooking, formatter);
            LocalDate currentDate = LocalDate.now();

            long year = ChronoUnit.YEARS.between(currentDate, starBook);
            long month = ChronoUnit.MONTHS.between(currentDate, starBook);
            long day = ChronoUnit.DAYS.between(currentDate, starBook);

            if (Pattern.matches(regexCheck, dateBooking)) {
                if(year >= 0){
                    if(month >= 0){
                        if(day >=0){
                            check = true;
                        }else {
                            System.out.println("ngay book phai lon hon ngay hom nay " + currentDate.toString());
                        }
                    }else {
                        System.out.println("ngay book phai lon hon ngay hom nay " + currentDate.toString());
                    }
                }else {
                    System.out.println("ngay book phai lon hon ngay hom nay " + currentDate.toString());
                }
            }else {
                System.out.println(" dịnh dạng ngày phải theo dd/MM/yyyy vd: 11/09/2021. hãy kiểm tra và điền lại ngày theo định dạng ");
            }
        }
        return dateBooking;
    }

    public String checkDateBookingEnd(String startBooking) {
        String regexCheck = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
        String dateBooking = null;
        boolean check = false;
        while (!check) {
            System.out.println(" nhap ngay ket thuc booking của bạn theo đúng định dạng dd/MM/yyyy; vd 11/11/2021");
            dateBooking = new Scan().input().nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate endbooking = LocalDate.parse(dateBooking, formatter);
            LocalDate starBook = LocalDate.parse(startBooking, formatter);
            LocalDate currentDate = LocalDate.now();

            long year = ChronoUnit.YEARS.between(starBook, endbooking);
            long month = ChronoUnit.MONTHS.between(starBook, endbooking);
            long day = ChronoUnit.DAYS.between(starBook, endbooking);

            if (Pattern.matches(regexCheck, dateBooking)) {
                if(year >= 0){
                    if(month >= 0){
                        if(day >=0){
                            check = true;
                        }else {
                            System.out.println("ngay book phai lon hon ngay hom nay " + starBook.toString());
                        }
                    }else {
                        System.out.println("ngay book phai lon hon ngay hom nay " + starBook.toString());
                    }
                }else {
                    System.out.println("ngay book phai lon hon ngay hom nay " + starBook.toString());
                }
            }else {
                System.out.println(" dịnh dạng ngày phải theo dd/MM/yyyy vd: 11/09/2021. hãy kiểm tra và điền lại ngày theo định dạng ");
            }
        }
        return dateBooking;
    }
}
