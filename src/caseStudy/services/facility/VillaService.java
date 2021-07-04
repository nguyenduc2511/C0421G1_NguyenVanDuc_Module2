package caseStudy.services.facility;

import caseStudy.models.facility.Villa;
import caseStudy.services.CRUDService;

import java.util.Map;

public interface VillaService extends CRUDService<Villa> {
    Map<Villa,Integer> getAllVilla();
    void updateData(Villa data);
    void fixData(Villa data);
    void displayFixData();
}
