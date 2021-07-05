package caseStudy.services.booking;

import caseStudy.DataStream.ReadWriteTreeSet;
import caseStudy.controllers.Choice;
import caseStudy.models.bookingAndContract.Booking;
import caseStudy.models.bookingAndContract.BookingComparatorDate;
import caseStudy.services.CustomerService.CustomverServiceImpl;
import caseStudy.services.facility.HouseServiceImpl;
import caseStudy.services.facility.RoomServiceImpl;
import caseStudy.services.facility.VillaServiceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {

    private static final String filepath = "src\\caseStudy\\data\\Booking.csv";
    private static final String filepathFinalBookYear = "src\\caseStudy\\data\\BookingYear.csv";

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
        String idbook = null;
        String idname = null;
        String idHouse = null;
        while (check) {
            System.out.println("1. book house vs id book la BH-01");
            System.out.println("2. book Room vs id book la BR-01");
            System.out.println("3. book Villa vs id book la BV-01");
            System.out.println("4. thoat them mới booking ");
            System.out.println("nhap lua chon cua ban");
            int choice = new Choice().choice();
            switch (choice) {
                case 1: {
                    new HouseServiceImpl().disPlay();
                    boolean check1 = false;
                    while (!check1) {
                        idbook = new CheckIdBook().idBooking();
                        check1 = new CheckIdBook().idBookingHouse(idbook);
                    }
                    idHouse = new HouseServiceImpl().checkDataBooking();
                    idname = "House";
                    new HouseServiceImpl().updateData(idHouse);
                    check = false;
                    break;
                }
                case 2: {
                    new RoomServiceImpl().disPlay();
                    boolean check1 = false;
                    while (!check1) {
                        System.out.println(" nhap id booking theo đúng định dạng BR-YY; vd BR-01");
                        idbook = new CheckIdBook().idBooking();
                        check1 = new CheckIdBook().idBookingRoom(idbook);
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
                    boolean check1 = false;
                    while (!check1) {
                        System.out.println(" nhap id booking theo đúng định dạng BV-YY; vd BV-01");
                        idbook = new CheckIdBook().idBooking();
                        check1 = new CheckIdBook().idBookingVilla(idbook);
                    }
                    System.out.println("nhap id house ban mua book ");
                    idHouse = new VillaServiceImpl().checkDataBooking();
                    new VillaServiceImpl().updateData(idHouse);
                    idname = "Villa";
                    check = false;
                    break;
                }
                case 4: {
                    check = false;
                }
                default:
                    break;
            }
        }
//                ngay bat dau
        String startBook = new CheckDatebooking().checkDateBookingStart();
//                    ngay ket thuc
        String endBook = new CheckDatebooking().checkDateBookingEnd(startBook);
//                    nhap id customer
        int idCustomer = new CustomverServiceImpl().CheckidBook();
        Booking booking = new Booking(idbook, startBook, endBook, idCustomer, idHouse, idname);
        bookingSet.add(booking);
        readwriteTreeSet.writeFileByteStream(bookingSet, filepath);
        readwriteTreeSet.writeFileByteStream(bookingSet, filepathFinalBookYear);
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
        readwriteTreeSet.writeFileByteStream(bookingSet, filepathFinalBookYear);
    }

    public void displayAllBooking() {
        Set<Booking> bookingSetFinal = new TreeSet<>(new BookingComparatorDate());
        bookingSetFinal = readwriteTreeSet.readFileByteStream(filepathFinalBookYear);
        for (Booking booking : bookingSetFinal) {
            System.out.println(booking.toString());
        }
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
