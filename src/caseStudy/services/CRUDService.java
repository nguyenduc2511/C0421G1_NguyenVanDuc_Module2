package caseStudy.services;

import module2.case_Study.models.facility.Room;

import java.util.List;

public interface CRUDService<T> {
    List<Room> getAll();
    void addNew();
    void editData();
    void disPlay();

}
