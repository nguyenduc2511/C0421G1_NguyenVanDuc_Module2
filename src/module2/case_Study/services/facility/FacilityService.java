package module2.case_Study.services.facility;

import caseStudy.models.facility.Facility;
import caseStudy.services.CRUDService;

public interface FacilityService extends CRUDService<Facility> {
    void displayFixData();
}
