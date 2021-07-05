package caseStudy.services.facility;

import caseStudy.models.facility.Room;
import caseStudy.services.CRUDService;

import java.util.Map;

public interface RoomService extends CRUDService<Room> {
    Map<Room,Integer> getAllRoom();
    void updateData(String data);
    void fixData(String data);
    void displayFixData();
}
