package caseStudy.services.facility;

import caseStudy.models.facility.Villa;
import caseStudy.services.CRUDService;

import java.util.Map;

public interface VillaService extends CRUDService<Villa> {
    Map<Villa,Integer> getAllVilla();
    void updateData(String data);
    void fixData();
    void displayFixData();
}
