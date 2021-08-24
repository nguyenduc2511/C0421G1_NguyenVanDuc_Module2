package module2.case_Study.models.bookingAndContract;

import java.io.Serializable;
import java.util.Objects;

public class Contract implements Serializable {
   private Integer contractNumber;
   private String bookingId;
   private Integer deposit;
   private Integer totalPayment;
   private Integer customerId;

    public Contract() {
    }

    public Contract(int contractNumber, String bookingId, int deposit, int totalPayment, int customerId) {
        this.contractNumber = contractNumber;
        this.bookingId = bookingId;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.customerId = customerId;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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
