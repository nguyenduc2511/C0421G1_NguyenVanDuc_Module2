package caseStudy.models.facility;

import java.io.Serializable;
import java.util.Objects;

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
        return "Room " + super.toString()+
                ", freeServices='" + freeServices + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return  super.equals(room)&&
                Objects.equals(freeServices, room.freeServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), freeServices);
    }
}
