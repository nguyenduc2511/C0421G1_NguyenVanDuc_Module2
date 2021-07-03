package caseStudy.models.facility;

import java.io.Serializable;

public class Room extends Facility implements Serializable {
    private String freeServices;

    public Room() {
    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String utilName, int useArea, int rentalFees, int maxNumsPeople, String rentalType, String freeServices) {
        super(utilName, useArea, rentalFees, maxNumsPeople, rentalType);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeServices='" + freeServices + '\'' +
                '}';
    }
}
