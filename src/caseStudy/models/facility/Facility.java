package caseStudy.models.facility;

import java.io.Serializable;

public abstract class Facility implements Serializable {
    private String utilName;
    private Integer useArea;
    private Integer rentalFees;
    private Integer maxNumsPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String utilName, int useArea, int rentalFees, int maxNumsPeople, String rentalType) {
        this.utilName = utilName;
        this.useArea = useArea;
        this.rentalFees = rentalFees;
        this.maxNumsPeople = maxNumsPeople;
        this.rentalType = rentalType;
    }

    public String getUtilName() {
        return utilName;
    }

    public void setUtilName(String utilName) {
        this.utilName = utilName;
    }

    public float getUseArea() {
        return useArea;
    }

    public void setUseArea(int useArea) {
        this.useArea = useArea;
    }

    public float getRentalFees() {
        return rentalFees;
    }

    public void setRentalFees(int rentalFees) {
        this.rentalFees = rentalFees;
    }

    public int getMaxNumsPeople() {
        return maxNumsPeople;
    }

    public void setMaxNumsPeople(int maxNumsPeople) {
        this.maxNumsPeople = maxNumsPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "utilName='" + utilName + '\'' +
                ", useArea=" + useArea +
                ", rentalFees=" + rentalFees +
                ", maxNumsPeople=" + maxNumsPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
