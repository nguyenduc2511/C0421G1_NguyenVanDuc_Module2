package caseStudy.services;

import caseStudy.DataStream.ReadWriteTreeSet;
import caseStudy.models.bookingAndContract.Booking;
import caseStudy.models.bookingAndContract.BookingComparatorDate;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService{

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

    }

    @Override
    public void editData() {

    }

    @Override
    public void disPlay() {

    }


}
