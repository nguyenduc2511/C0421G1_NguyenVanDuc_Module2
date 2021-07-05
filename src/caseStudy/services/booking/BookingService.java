package caseStudy.services.booking;

import caseStudy.models.bookingAndContract.Booking;
import caseStudy.services.CRUDService;

import java.util.Set;

public interface BookingService extends CRUDService {
        Set<Booking> getAllBooking();
}
