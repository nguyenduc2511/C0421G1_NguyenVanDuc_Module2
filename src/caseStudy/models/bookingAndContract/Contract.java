package caseStudy.models.bookingAndContract;

import java.util.Objects;

public class Contract {
   private String contractNumber;
   private String bookingId;
   private double deposit;
   private double totalPayment;
   private String customerId;

    public Contract() {
    }

    public Contract(String contractNumber, String bookingId, double deposit, double totalPayment, String customerId) {
        this.contractNumber = contractNumber;
        this.bookingId = bookingId;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.customerId = customerId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber='" + contractNumber + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                ", customerId='" + customerId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Double.compare(contract.deposit, deposit) == 0 &&
                Double.compare(contract.totalPayment, totalPayment) == 0 &&
                Objects.equals(contractNumber, contract.contractNumber) &&
                Objects.equals(bookingId, contract.bookingId) &&
                Objects.equals(customerId, contract.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractNumber, bookingId, deposit, totalPayment, customerId);
    }
}
