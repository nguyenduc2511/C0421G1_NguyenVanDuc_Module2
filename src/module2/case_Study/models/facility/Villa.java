package module2.case_Study.models.facility;

import java.io.Serializable;
import java.util.Objects;

public class Villa extends Facility implements Serializable {
    private String roomStandard;
    private int poolArea;
    private int floors;

    public Villa() {
    }

    public Villa(String roomStandard, int poolArea, int floors) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public Villa(String utilName, int useArea, int rentalFees, int maxNumsPeople, String rentalType, String roomStandard, int poolArea, int floors) {
        super(utilName, useArea, rentalFees, maxNumsPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Villa " + super.toString()+
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", floors=" + floors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Villa villa = (Villa) o;
        return  super.equals(villa)&&
                Float.compare(villa.poolArea, poolArea) == 0 &&
                floors == villa.floors &&
                Objects.equals(roomStandard, villa.roomStandard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roomStandard, poolArea, floors);
    }
}
