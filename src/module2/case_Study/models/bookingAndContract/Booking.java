package module2.case_Study.models.bookingAndContract;

import java.io.Serializable;
import java.util.Objects;

public class Booking implements Serializable,Comparable {
    private String bookingId;
    private String startDay;
    private String endDay;
    private Integer customerId;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }
    public Booking(String bookingId, String startDay, String endDay, int customerId, String serviceName, String serviceType) {
        this.bookingId = bookingId;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerId = customerId;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", customerId='" + customerId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) &&
                Objects.equals(startDay, booking.startDay) &&
                Objects.equals(endDay, booking.endDay) &&
                Objects.equals(customerId, booking.customerId) &&
                Objects.equals(serviceName, booking.serviceName) &&
                Objects.equals(serviceType, booking.serviceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, startDay, endDay, customerId, serviceName, serviceType);
    }

    @Override
    public int compareTo(Object o) {

        return 0;
    }
}
