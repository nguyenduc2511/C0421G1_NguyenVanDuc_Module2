package module2.case_Study.models.facility;

import java.io.Serializable;
import java.util.Objects;

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

    public int getUseArea() {
        return useArea;
    }

    public void setUseArea(int useArea) {
        this.useArea = useArea;
    }

    public int getRentalFees() {
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
                ", rentalType='" + rentalType + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(utilName, facility.utilName) &&
                Objects.equals(useArea, facility.useArea) &&
                Objects.equals(rentalFees, facility.rentalFees) &&
                Objects.equals(maxNumsPeople, facility.maxNumsPeople) &&
                Objects.equals(rentalType, facility.rentalType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilName, useArea, rentalFees, maxNumsPeople, rentalType);
    }
}
