package caseStudy.services;

import caseStudy.models.bookingAndContract.Booking;

import java.util.Set;

public interface BookingService extends CRUDService{
        Set<Booking> getAllBooking();
}
