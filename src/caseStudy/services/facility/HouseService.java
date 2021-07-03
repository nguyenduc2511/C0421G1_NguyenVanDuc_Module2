package caseStudy.services.facility;

import caseStudy.models.facility.House;
import caseStudy.services.CRUDService;

import java.util.Map;

public interface HouseService extends CRUDService<House> {
    Map<House,Integer> getAllHouse();
}
