package caseStudy.services.PromotionService;

import caseStudy.DataStream.ReadWriteTreeSet;
import caseStudy.Scan;
import caseStudy.controllers.Choice;
import caseStudy.models.bookingAndContract.Booking;
import caseStudy.models.bookingAndContract.BookingComparatorDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class PromotionServiceImpl implements PromotionService{
    private static final String filepathFinalBookYear = "src\\caseStudy\\data\\BookingYear.csv";
    private static final ReadWriteTreeSet readwriteTreeSet = new ReadWriteTreeSet();
    private static Set<Booking> promotionBooking = new TreeSet<>(new BookingComparatorDate());


    @Override
    public Set<Booking> getAllBooking() {
        promotionBooking = readwriteTreeSet.readFileByteStream(filepathFinalBookYear);
        return promotionBooking;
    }

    @Override
    public void displayPlayByYear() {
        new PromotionServiceImpl().getAllBooking();
        boolean check = false;
        String years=null;
        while (!check){
            System.out.println("nhap nam ban muon hien thi");
            String regexCheck ="^d{4}";
             years = new Scan().input().nextLine();
            if (Pattern.matches(regexCheck, years)){
                check=true;
            }
        }
        for (Booking booking: promotionBooking){
            String dateBooking = booking.getStartDay();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
            LocalDate yearBook = LocalDate.parse(years, formatter);
            LocalDate starBook = LocalDate.parse(dateBooking, formatter);
            long year = ChronoUnit.YEARS.between(yearBook, starBook);
            if (year ==0){
                System.out.println(booking.toString());
            }
        }
    }

    @Override
    public void voucher() {
        new PromotionServiceImpl().getAllBooking();
        Stack<Booking> voucherBooking = new Stack<>();
        for (Booking booking: promotionBooking){
            String dateBooking = booking.getStartDay();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate starBook = LocalDate.parse(dateBooking, formatter);
            LocalDate currentDate = LocalDate.now();
            long month = ChronoUnit.MONTHS.between(currentDate, starBook);
            if (month ==0){
                voucherBooking.push(booking);
                System.out.println(booking.toString());
            }
        }

        boolean check = false;
        int voucher10=0;
        int voucher20=0;
        int voucher50=0;
        while (!check){
            System.out.println("tong so voucher se phat = " + voucherBooking.size());
            System.out.println("nhap so voucher 10%");
             voucher10 = new Choice().choice();
            System.out.println("nhap so voucher 20%");
             voucher20 = new Choice().choice();
            System.out.println("nhap so voucher 50%");
             voucher50 = voucherBooking.size()- voucher10 - voucher20;
            if((voucher50>=0)){
                check = true;
            }
        }
        for(int i =1; i<=voucher10;i++){
            if(!voucherBooking.empty()){
                System.out.println(voucherBooking.pop().toString() +" da được tặng voucher 10%");
            }
        }
        for(int i =1; i<=voucher20;i++){
            if(!voucherBooking.empty()){
                System.out.println(voucherBooking.pop().toString() +" da được tặng voucher 20%");
            }
        }
        for(int i =1; i<=voucher50;i++){
            if(!voucherBooking.empty()){
                System.out.println(voucherBooking.pop().toString() +" da được tặng voucher 50%");
            }
        }
    }
}
