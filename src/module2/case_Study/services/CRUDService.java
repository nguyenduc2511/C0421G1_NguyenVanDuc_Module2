package module2.case_Study.services;

import java.util.List;

public interface CRUDService<T> {
    List<T> getAll();
    void addNew();
    void editData();
    void disPlay();

}
