package caseStudy.services.booking;

import caseStudy.DataStream.ReadWriteTreeSet;
import caseStudy.controllers.Choice;
import caseStudy.models.bookingAndContract.Booking;
import caseStudy.models.bookingAndContract.BookingComparatorDate;
import caseStudy.services.CustomerService.CustomverServiceImpl;
import caseStudy.services.facility.HouseServiceImpl;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {

    private static final String filepath = "src\\caseStudy\\data\\Booking.csv";
    private static final ReadWriteTreeSet readwriteTreeSet = new ReadWriteTreeSet();
    private static Set<Booking> bookingSet = new TreeSet<>(new BookingComparatorDate());

    @Override
    public Set<Booking> getAllBooking() {
        bookingSet = readwriteTreeSet.readFileByteStream(filepath);
        return bookingSet;
    }
    @Override
    public List getAll() {
        return null;
    }


    @Override
    public void addNew() {
        new BookingServiceImpl().getAllBooking();
        boolean check = true;
        while (true){
            System.out.println("1. book house");
            System.out.println("2. book Room");
            System.out.println("3. book Villa");
            System.out.println("4. thoat them mới booking ");
            System.out.println("nhap lua chon cua ban");
            int choice = new Choice().choice();
            switch (choice){
                case 1:{
                    new HouseServiceImpl().disPlay();
                    String idbook = new CheckIdBook().idBookingHouse();
//                    ngay bat dau
                    String startBook = new CheckDatebooking().checkDateBookingStart();
//                    ngay ket thuc
                    String endBook = new  CheckDatebooking().checkDateBookingEnd(startBook);
//                    nhap id customer
                    int idCustomer = new CustomverServiceImpl().CheckidBook();
                    System.out.println("nhap id house ban mua book ");
                    String idHouse = new HouseServiceImpl().checkDataBooking();

                }
                case 2:{

                }
                case 3:{

                }
                case 4:{

                }
            }


        }




    }

    @Override
    public void editData() {

    }

    @Override
    public void disPlay() {

    }


}
