package exam_module2.services;

import java.util.List;

public interface CRUDServiceExam<T> {
    List<T> getAll();
    void addNew();
    void findData(String a);
    void disPlay();
    void removeData(String a);
}
