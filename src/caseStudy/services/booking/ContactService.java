package caseStudy.services.booking;

import caseStudy.models.bookingAndContract.Booking;
import caseStudy.services.CRUDService;

import java.util.Queue;

public interface ContactService extends CRUDService {

    Queue<Booking> getAllBookByQueue();
}
