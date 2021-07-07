package caseStudy.services.PromotionService;

import caseStudy.DataStream.ReadAndWriteByteStream;
import caseStudy.DataStream.ReadWriteTreeSet;
import caseStudy.utils.Scan;
import caseStudy.utils.Choice;
import caseStudy.models.bookingAndContract.Booking;
import caseStudy.models.bookingAndContract.BookingComparatorDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Pattern;

public class PromotionServiceImpl implements PromotionService{
    private static final String filepathFinalBookYear = "src\\caseStudy\\data\\BookingYear.csv";
    private static final ReadWriteTreeSet readwriteTreeSet = new ReadWriteTreeSet();
    private static Set<Booking> promotionBooking = new TreeSet<>(new BookingComparatorDate());
    private static final ReadAndWriteByteStream<Booking> readAndWriterByte = new ReadAndWriteByteStream<>();


    @Override
    public Set<Booking> getAllBooking() {
        List<Booking> list = readAndWriterByte.readFileByteStream(filepathFinalBookYear);
        promotionBooking.addAll(list);
        return promotionBooking;
    }

    @Override
    public void displayPlayByYear() {
        new PromotionServiceImpl().getAllBooking();
        boolean check = false;
        String years=null;
        String yeart ="01/01/";
        while (!check){
            System.out.println("nhap nam ban muon hien thi");
            String regexCheck = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
             years = yeart +new Scan().input().nextLine();
            check = Pattern.matches(regexCheck, years);
        }
        for (Booking booking: promotionBooking){
            String dateBooking = booking.getStartDay();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
             voucher50 = voucherBooking.size()- voucher10 - voucher20;
            System.out.println(" so voucher 50% kha dung = " + voucher50 );
            if((voucher50>=0)){
                check = true;
            }else {
                System.out.println(" vui long nhap lai ");
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
