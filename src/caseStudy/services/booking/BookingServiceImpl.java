package caseStudy.services.booking;

import caseStudy.DataStream.ReadAndWriteByteStream;
import caseStudy.DataStream.ReadWriteTreeSet;
import caseStudy.controllers.Choice;
import caseStudy.models.bookingAndContract.Booking;
import caseStudy.models.bookingAndContract.BookingComparatorDate;
import caseStudy.services.CustomerService.CustomverServiceImpl;
import caseStudy.services.facility.HouseServiceImpl;
import caseStudy.services.facility.RoomServiceImpl;
import caseStudy.services.facility.VillaServiceImpl;

import java.util.*;

public class BookingServiceImpl implements BookingService {

    private static final String filepath = "src\\caseStudy\\data\\Booking.csv";
    private static final String filepathFinalBookYear = "src\\caseStudy\\data\\BookingYear.csv";

    private static final ReadWriteTreeSet readwriteTreeSet = new ReadWriteTreeSet();
    public static final ReadAndWriteByteStream<Booking> readAndWriteByteStream = new ReadAndWriteByteStream<Booking>();
    private static TreeSet<Booking> bookingSet = new TreeSet<>(new BookingComparatorDate());
    private static List<Booking> bookingSetyears = new ArrayList<>();

    @Override
    public TreeSet<Booking> getAllBooking() {
        bookingSet = (TreeSet<Booking>) readwriteTreeSet.readFileByteStream(filepath);
        return bookingSet;
    }

    public List<Booking> getAllBookingYear() {
        bookingSetyears = readAndWriteByteStream.readFileByteStream(filepathFinalBookYear);
        return bookingSetyears;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void addNew() {
        new BookingServiceImpl().getAllBooking();
        boolean check = true;
        String idbook = null;
        String idname = null;
        String idHouse = null;
        while (check) {
            System.out.println("1. book house vs id book la BH-01");
            System.out.println("2. book Room vs id book la BR-01");
            System.out.println("3. book Villa vs id book la BV-01");
            System.out.println("nhap lua chon cua ban");
            int choice = new Choice().choice();
            switch (choice) {
                case 1: {
                    new HouseServiceImpl().disPlay();
                    boolean check1 = true;
                    while (check1) {
                        idbook = new CheckIdBook().idBooking();
                        for (Booking booking : bookingSet) {
                            String[] a = booking.getBookingId().split("-", 2);
                            String[] b = idbook.split("-", 2);
                            if (a[0].equals(b[0])) {
                                if (!booking.getBookingId().equals(idbook) && new CheckIdBook().idBookingHouse(idbook)&& bookingSet.last().getBookingId().equals(booking.getBookingId())) {
                                    check1 = false;
                                    break;
                                }
                            }
                        }
                        if(check){
                            System.out.println(idbook + " da trung lap!!! hay ");
                        }
                    }
                    System.out.println("nhap id House ban mua book ");
                    idHouse = new HouseServiceImpl().checkDataBooking();
                    idname = "House";
                    new HouseServiceImpl().updateData(idHouse);
                    check = false;
                    break;
                }
                case 2: {
                    new RoomServiceImpl().disPlay();
                    boolean check1 = true;
                    while (check1) {
                        idbook = new CheckIdBook().idBooking();
                        for (Booking booking : bookingSet) {
                            String[] a = booking.getBookingId().split("-", 2);
                            String[] b = idbook.split("-", 2);
                            if (a[0].equals(b[0])) {
                                if (!booking.getBookingId().equals(idbook) && new CheckIdBook().idBookingRoom(idbook)&& bookingSet.last().getBookingId().equals(booking.getBookingId())) {
                                    check1 = false;
                                    break;
                                }
                            }
                        }
                       if(check){
                           System.out.println(idbook + " da trung lap!!! hay ");
                       }
                    }
                        System.out.println("nhap id Room ban muon book ");
                        idHouse = new RoomServiceImpl().checkDataBooking();
                        idname = "Room";
                        new RoomServiceImpl().updateData(idHouse);
                        check = false;
                        break;
                }
                case 3: {
                    new VillaServiceImpl().disPlay();
                    boolean check1 = true;
                    while (check1) {
                        idbook = new CheckIdBook().idBooking();
                        for (Booking booking : bookingSet) {
                            String[] a = booking.getBookingId().split("-", 2);
                            String[] b = idbook.split("-", 2);
                            if (a[0].equals(b[0])) {
                                if (!booking.getBookingId().equals(idbook) && new CheckIdBook().idBookingVilla(idbook)&& bookingSet.last().getBookingId().equals(booking.getBookingId())) {
                                    check1 = false;
                                    break;
                                }
                            }
                        }
                        if(check){
                            System.out.println(idbook + " da trung lap!!! hay ");
                        }
                    }
                    System.out.println("nhap id Villa ban mua book ");
                    idHouse = new VillaServiceImpl().checkDataBooking();
                    new VillaServiceImpl().updateData(idHouse);
                    idname = "Villa";
                    check = false;
                    break;
                }
                default:
                    break;
            }
        }
        String startBook = new CheckDatebooking().checkDateBookingStart();
        String endBook = new CheckDatebooking().checkDateBookingEnd(startBook);
        int idCustomer = new CustomverServiceImpl().CheckidBook();
        Booking booking = new Booking(idbook, startBook, endBook, idCustomer, idHouse, idname);
        bookingSet.add(booking);
        readwriteTreeSet.writeFileByteStream(bookingSet, filepath);
    }


    @Override
    public void editData() {
        new BookingServiceImpl().getAllBooking();
        new BookingServiceImpl().disPlay();
//        System.out.println("nhap id booking ban mua sua ");
        String idbook = new CheckIdBook().idBooking();
        for (Booking booking : bookingSet) {
            if (booking.getBookingId().equals(idbook)) {
                boolean check = true;
                String idbookNew = booking.getBookingId();
                String startBook = booking.getStartDay();
                String endBook = booking.getEndDay();
                int idCustomer = booking.getCustomerId();
                String idHouse = booking.getServiceName();
                String idHouseName = booking.getServiceType();
                while (check) {
                    System.out.println("ban muon sua thong tin cho " + booking.toString());
                    System.out.println("1. mã booking" +
                            "2. ngày bắt đầu" +
                            "3.ngày kết thúc" +
                            "4. mã khách hàng" +
                            "5. tên dịch vụ");
                    System.out.println("6. thoat chinh sua ");
                    System.out.println("nhap lua con cua ban ");
                    int choice = new Choice().choice();
                    switch (choice) {
                        case 1: {
                            idbookNew = new CheckIdBook().idBooking();
                            break;
                        }
                        case 2: {
//                            ngay bat dau
                            startBook = new CheckDatebooking().checkDateBookingStart();
                            break;
                        }
                        case 3: {
//                    ngay ket thuc
                            endBook = new CheckDatebooking().checkDateBookingEnd(startBook);
                            break;
                        }
                        case 4: {
                            idCustomer = new CustomverServiceImpl().CheckidBook();
                            break;
                        }
                        case 5: {
                            if (new CheckIdBook().idBookingHouse(idbookNew)) {
                                System.out.println("nhap id house ban muon book voi ma la  ");
                                idHouse = new HouseServiceImpl().checkDataBooking();
                                idHouseName = "House";
                                break;
                            } else if (new CheckIdBook().idBookingRoom(idbookNew)) {
                                System.out.println("nhap id Room ban muon book ");
                                idHouse = new RoomServiceImpl().checkDataBooking();
                                idHouseName = "Room";
                                break;
                            } else if (new CheckIdBook().idBookingVilla(idbookNew)) {
                                System.out.println("nhap id house ban mua book ");
                                idHouse = new VillaServiceImpl().checkDataBooking();
                                new VillaServiceImpl().updateData(idHouse);
                                idHouseName = "Villa";
                                break;
                            }
                        }
                        case 6:
                            check = false;
                        default:
                            break;
                    }
                }
                Booking booking3 = new Booking(idbook, startBook, endBook, idCustomer, idHouse, idHouseName);
                bookingSet.remove(booking);
                bookingSet.add(booking3);
                break;

            }
        }
        readwriteTreeSet.clearData(filepath);
        readwriteTreeSet.writeFileByteStream(bookingSet, filepath);
    }

    public void displayAllBooking() {
        new BookingServiceImpl().getAllBookingYear();
        for (Booking booking : bookingSetyears) {
            System.out.println(booking.toString());
        }
    }

    public void editContract(String idold, String idNew) {
        new BookingServiceImpl().getAllBookingYear();
        new BookingServiceImpl().getAllBooking();
        Iterator<Booking> iterator = bookingSetyears.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getBookingId().equals(idold)) {
                iterator.remove();
            }
        }
        for (Booking booking : bookingSet) {
            if (booking.getBookingId().equals(idNew)) {
                bookingSetyears.add(booking);
                break;
            }
        }
        readAndWriteByteStream.clearData(filepathFinalBookYear);
        readAndWriteByteStream.writeFileByteStream(bookingSetyears, filepathFinalBookYear);
    }

    public void addContract(String id) {
        new BookingServiceImpl().getAllBookingYear();
        new BookingServiceImpl().getAllBooking();
        for (Booking booking : bookingSet) {
            if (booking.getBookingId().equals(id)) {
                bookingSetyears.add(booking);
                break;
            }
        }
        readAndWriteByteStream.writeFileByteStream(bookingSetyears, filepathFinalBookYear);
    }

    @Override
    public void disPlay() {
        new BookingServiceImpl().getAllBooking();
        for (Booking booking : bookingSet) {
            System.out.println(booking.toString());
        }
    }

    public void removeBooking(String idbooking) {
        new BookingServiceImpl().getAllBooking();
        Iterator<Booking> iterator = bookingSet.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getBookingId().equals(idbooking)) {
                iterator.remove();
            }
        }
        readwriteTreeSet.clearData(filepath);
        readwriteTreeSet.writeFileByteStream(bookingSet, filepath);
    }
}
