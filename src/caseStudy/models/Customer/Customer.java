package caseStudy.models.Customer;

import caseStudy.models.employee.Person;

import java.io.Serializable;

public class Customer extends Person implements Serializable {
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String customerType, String address) {
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(Integer code, String fullName, String dateOfBirth, String gender, String idNumber, String phoneNumber, String email, String customerType, String address) {
        super(code, fullName, dateOfBirth, gender, idNumber, phoneNumber, email);
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
