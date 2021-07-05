package caseStudy.services.PromotionService;

import caseStudy.models.bookingAndContract.Booking;

import java.util.Set;

public interface PromotionService {
    Set<Booking> getAllBooking();
    void displayPlayByYear();
    void voucher();
}
