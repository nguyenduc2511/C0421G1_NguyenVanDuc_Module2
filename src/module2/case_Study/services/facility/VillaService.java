package module2.case_Study.services.facility;


import module2.case_Study.models.facility.Villa;
import module2.case_Study.services.CRUDService;

import java.util.Map;

public interface VillaService extends CRUDService<Villa> {
    Map<Villa,Integer> getAllVilla();
    void updateData(String data);
    void fixData();
    void displayFixData();
}
