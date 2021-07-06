package caseStudy.services.booking;

import caseStudy.DataStream.ReadAndWriteByteStream;
import caseStudy.controllers.Choice;
import caseStudy.models.bookingAndContract.Booking;
import caseStudy.models.bookingAndContract.Contract;
import caseStudy.services.CustomerService.CustomverServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ContactServiceImpl implements ContactService {
    private static final String filepath = "src\\caseStudy\\data\\Contact.csv";
    //    private static final ReadWriteTreeSet readwriteTreeSet = new ReadWriteTreeSet();
    public static final ReadAndWriteByteStream<Contract> readAndWriteByteStream = new ReadAndWriteByteStream<Contract>();
    private static final Queue<Booking> bookingtoQueue = new PriorityQueue<>();
    private static List<Contract> contractList = new ArrayList<>();

    @Override
    public List<Contract> getAll() {
        contractList = readAndWriteByteStream.readFileByteStream(filepath);
        return contractList;
    }

    @Override
    public Queue<Booking> getAllBookByQueue() {
        Set<Booking> bookingSet = new BookingServiceImpl().getAllBooking();
        for (Booking booking : bookingSet) {
            if (new CheckIdBook().idBookingHouse(booking.getBookingId()) || new CheckIdBook().idBookingVilla(booking.getBookingId())) {
                bookingtoQueue.offer(booking);
            }
        }
        return bookingtoQueue;
    }

    @Override
    public void addNew() {
        new ContactServiceImpl().getAll();
        new ContactServiceImpl().getAllBookByQueue();
        boolean check = false;

        if (!bookingtoQueue.isEmpty()) {
            while (!check) {
                Booking bookingContract = bookingtoQueue.poll();
                String idBooking = bookingContract.getBookingId();
                if (new CheckIdBook().idBookingHouse(idBooking) || new CheckIdBook().idBookingVilla(idBooking)) {
                    int idContract = 0;
                    if (contractList.isEmpty()) {
                        idContract = 1;
                    } else {
                        idContract = contractList.get(contractList.size() - 1).getContractNumber() + 1;
                    }
                    System.out.println("danh sach booking con lai : ");
                    new BookingServiceImpl().disPlay();
                    System.out.println("ban se lam hop dong voi booking nay: ");
                    System.out.println(bookingContract.toString());

                    new BookingServiceImpl().removeBooking(idBooking);

                    System.out.println("nhap so tien coc USD");
                    int moneyF = new Choice().choice();
                    String startB = bookingContract.getStartDay();
                    String endB = bookingContract.getEndDay();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate starBook = LocalDate.parse(startB, formatter);
                    LocalDate endbook = LocalDate.parse(endB, formatter);
                    int day = (int) ChronoUnit.DAYS.between(starBook, endbook);
                    int paydayMoney = 0;
                    if (new CheckIdBook().idBookingHouse(idBooking)) {
                        paydayMoney = day * 700 - moneyF;
                        new BookingServiceImpl().addContract(idBooking);
                    } else if (new CheckIdBook().idBookingVilla(idBooking)) {
                        paydayMoney = day * 1000 - moneyF;
                        new BookingServiceImpl().addContract(idBooking);
                    }
                    int idCustomer = bookingContract.getCustomerId();
                    Contract contract1 = new Contract(idContract, idBooking, moneyF, paydayMoney, idCustomer);
                    contractList.add(contract1);
                    readAndWriteByteStream.writeFileByteStream(contractList, filepath);
                    check = true;
                }else {
                    new BookingServiceImpl().removeBooking(idBooking);
                    new BookingServiceImpl().addContract(idBooking);
                }
            }
        } else {
            System.out.println("khong co booking nao de lam hop dong");
        }
    }


    @Override
    public void editData() {
        new ContactServiceImpl().getAll();
        new ContactServiceImpl().disPlay();
        System.out.println("nhap id contract ban muon sua ");
        int idcontract = new Choice().choice();
        for (int i = 0; i < contractList.size(); i++) {
            if (contractList.get(i).getContractNumber() == idcontract) {
                boolean check = true;
                while (check) {
                    System.out.println("1.sua id booking");
                    System.out.println("2. nhap so tien coc ");
                    System.out.println("3. nhap tong so tien phai thanh toan ");
                    System.out.println("4. nhap id customer can thay doi ");
                    System.out.println("5. thoat chinh sua");
                    System.out.println("nhap lua chon");
                    int choice = new Choice().choice();
                    switch (choice) {
                        case 1: {
                            String idold = contractList.get(i).getBookingId();
                            String idbookNew = new CheckIdBook().idBooking();
                            contractList.get(i).setBookingId(idbookNew);
                            new BookingServiceImpl().editContract(idold, idbookNew);
                            break;
                        }
                        case 2: {
                            int moneyF = new Choice().choice();
                            contractList.get(i).setDeposit(moneyF);
                            break;
                        }
                        case 3: {
                            int paydayMoney = new Choice().choice();
                            contractList.get(i).setTotalPayment(paydayMoney);
                            break;
                        }
                        case 4: {
                            new CustomverServiceImpl().disPlay();
                            int idCustomer = new CustomverServiceImpl().CheckidBook();
                            contractList.get(i).setCustomerId(idCustomer);
                            break;
                        }
                        case 5: {
                            check = false;
                        }
                        default:
                            break;
                    }
                }
            }
            break;
        }
        readAndWriteByteStream.clearData(filepath);
        readAndWriteByteStream.writeFileByteStream(contractList, filepath);
    }

    @Override
    public void disPlay() {
        new ContactServiceImpl().getAll();
        for (Contract contract : contractList) {
            System.out.println(contract.toString());
        }
    }
}
