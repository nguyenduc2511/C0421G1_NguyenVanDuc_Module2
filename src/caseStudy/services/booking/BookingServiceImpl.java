package caseStudy.services.booking;

import caseStudy.DataStream.ReadAndWriteByteStream;
import caseStudy.DataStream.ReadWriteTreeSet;
import caseStudy.utils.Choice;
import caseStudy.models.bookingAndContract.Booking;
import caseStudy.models.bookingAndContract.BookingComparatorDate;
import caseStudy.services.CustomerService.CustomverServiceImpl;
import caseStudy.services.facility.HouseServiceImpl;
import caseStudy.services.facility.RoomServiceImpl;
import caseStudy.services.facility.VillaServiceImpl;
import caseStudy.utils.CheckDatebooking;
import caseStudy.utils.CheckIdBook;

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
        new BookingServiceImpl().getAllBookingYear();
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
                        int count = 0;
                        int count2 = 0;
                        idbook = new CheckIdBook().idBooking();
                        if (new CheckIdBook().idBookingHouse(idbook)) {
                            for (Booking booking : bookingSetyears) {
                                if (!booking.getBookingId().equals(idbook)) {
                                    count++;
                                }
                            }

                            for (Booking booking : bookingSet) {
                                if (!booking.getBookingId().equals(idbook)) {
                                    count2++;
                                }
                            }
                        }
                        if (count == bookingSetyears.size() && count2 == bookingSet.size()) {
                            check1 = false;
                        } else {
                            for (Booking booking : bookingSetyears) {
                                System.out.print(booking.getBookingId()+"; ");
                            }
                            for (Booking booking : bookingSet) {
                                System.out.print(booking.getBookingId()+"; ");
                            }
                            System.out.println("\n");
                            System.out.print(idbook + " da bi trung lap o tren hoac ban nhap sai dinh dang BH-YY !!! hay ");
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
                        int count = 0;
                        int count2 = 0;
                        idbook = new CheckIdBook().idBooking();
                        if (new CheckIdBook().idBookingRoom(idbook)) {
                            for (Booking booking : bookingSetyears) {
                                if (!booking.getBookingId().equals(idbook)) {
                                    count++;
                                }
                            }
                            for (Booking booking : bookingSet) {
                                if (!booking.getBookingId().equals(idbook)) {
                                    count2++;
                                }
                            }
                        }
                        if (count == bookingSetyears.size() && count2 == bookingSet.size()) {
                            check1 = false;
                        } else {
                            for (Booking booking : bookingSetyears) {
                                System.out.print(booking.getBookingId()+"; ");
                            }
                            for (Booking booking : bookingSet) {
                                System.out.print(booking.getBookingId()+"; ");
                            }
                            System.out.println("\n");
                            System.out.print(idbook + " da bi trung lap o tren hoac ban nhap sai dinh dang BR-YY !!! hay ");
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
                        int count = 0;
                        int count2 = 0;
                        idbook = new CheckIdBook().idBooking();
                        if (new CheckIdBook().idBookingVilla(idbook)) {
                            for (Booking booking : bookingSetyears) {
                                if (!booking.getBookingId().equals(idbook)) {
                                    count++;
                                }
                            }

                            for (Booking booking : bookingSet) {
                                if (!booking.getBookingId().equals(idbook)) {
                                    count2++;
                                }
                            }
                        }
                        if (count == bookingSetyears.size() && count2 == bookingSet.size()) {
                            check1 = false;
                        } else {
                            for (Booking booking : bookingSetyears) {
                                System.out.print(booking.getBookingId()+"; ");
                            }
                            for (Booking booking : bookingSet) {
                                System.out.print(booking.getBookingId()+"; ");
                            }
                            System.out.println("\n");
                            System.out.print(idbook + " da bi trung lap o tren hoac ban nhap sai dinh dang BV-YY !!! hay ");
                        }
                    }
                    System.out.println("nhap id Villa ban muon book ");
                    idHouse = new VillaServiceImpl().checkDataBooking();
                    idname = "Villa";
                    new VillaServiceImpl().updateData(idHouse);
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
        if (!bookingSet.isEmpty()) {
            boolean checkT = true;
            while (checkT) {
                String idbook = new CheckIdBook().idBooking();
                System.out.println("1. xoa booking");
                System.out.println("2. sua thong tin ");
                System.out.println(" nhap lua con cua ban ");
                int choiceT = new Choice().choice();
                switch (choiceT) {
                    case 1: {
                        for(Booking booking : bookingSet){
                            if (booking.getBookingId().equals(idbook)) {
                                new BookingServiceImpl().removeBooking(idbook);
                               String[]str = booking.getServiceName().split("-",2);
                                if(str[0].equals("SVHO")){
                                    new HouseServiceImpl().updateDataLow(booking.getServiceName());
                                }else if(str[0].equals("SVRO")){
                                    new RoomServiceImpl().updateDataLow(booking.getServiceName());
                                }else if(str[0].equals("SVVL")){
                                    new VillaServiceImpl().updateDataLow(booking.getServiceName());
                                }
                                checkT =false;
                            }
                        }
                        break;
                    }
                    case 2: {
                        for (Booking booking : bookingSet) {
                            if (booking.getBookingId().equals(idbook)) {
                                boolean check = true;
                                checkT = false;
                                String idbookNew = booking.getBookingId();
                                String startBook = booking.getStartDay();
                                String endBook = booking.getEndDay();
                                int idCustomer = booking.getCustomerId();
                                String idHouse = booking.getServiceName();
                                String idHouseName = booking.getServiceType();
                                while (check) {
                                    System.out.println("ban muon sua thong tin cho " + booking.toString());
                                    System.out.println("1. ngày bắt đầu");
                                    System.out.println("2. ngày kết thúc");
                                    System.out.println("3. mã khách hàng");
                                    System.out.println("4. tên dịch vụ");
                                    System.out.println("5. thoat chinh sua ");
                                    System.out.println("nhap lua con cua ban ");
                                    int choice = new Choice().choice();
                                    switch (choice) {
                                        case 1: {
                                            startBook = new CheckDatebooking().checkDateBookingStart();
                                            break;
                                        }
                                        case 2: {
                                            endBook = new CheckDatebooking().checkDateBookingEnd(startBook);
                                            break;
                                        }
                                        case 3: {
                                            idCustomer = new CustomverServiceImpl().CheckidBook();
                                            break;
                                        }
                                        case 4: {
                                            if (new CheckIdBook().idBookingHouse(idbookNew)) {
                                                new HouseServiceImpl().updateDataLow(idHouse);
                                                System.out.println("nhap id house ban muon book voi ma la  ");
                                                idHouse = new HouseServiceImpl().checkDataBooking();
                                                new HouseServiceImpl().updateDataLow(idHouse);
                                                idHouseName = "House";
                                                break;
                                            } else if (new CheckIdBook().idBookingRoom(idbookNew)) {
                                                new RoomServiceImpl().updateDataLow(idHouse);
                                                System.out.println("nhap id Room ban muon book ");
                                                idHouse = new RoomServiceImpl().checkDataBooking();
                                                new RoomServiceImpl().updateData(idHouse);
                                                idHouseName = "Room";
                                                break;
                                            } else if (new CheckIdBook().idBookingVilla(idbookNew)) {
                                                new VillaServiceImpl().updateDataLow(idHouse);
                                                System.out.println("nhap id house ban mua book ");
                                                idHouse = new VillaServiceImpl().checkDataBooking();
                                                new VillaServiceImpl().updateData(idHouse);
                                                idHouseName = "Villa";
                                                break;
                                            }
                                        }
                                        case 5:
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
                    }
                }
                if (checkT) {
                    System.out.println("khong co trong danh sach booking vui long nhap lai ");
                }
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

    public void saveBooking(String idbooking) {
        new BookingServiceImpl().getAllBookingYear();
        new BookingServiceImpl().getAllBooking();
        for (Booking booking : bookingSet) {
            if (booking.getBookingId().equals(idbooking)) {
                bookingSetyears.add(booking);
                break;
            }
        }
        readAndWriteByteStream.writeFileByteStream(bookingSetyears, filepathFinalBookYear);
    }

    @Override
    public void disPlay() {
        new BookingServiceImpl().getAllBooking();
        if (!bookingSet.isEmpty()) {
            for (Booking booking : bookingSet) {
                System.out.println(booking.toString());
            }
        } else {
            System.out.println("khong co booking trong hang chờ");
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
