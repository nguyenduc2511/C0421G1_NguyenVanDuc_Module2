package module2.case_Study.services.facility;

import caseStudy.utils.Choice;
import module2.case_Study.models.facility.Room;

import java.util.List;

public class FacilityServiceImpl implements FacilityService {

    @Override
    public List<Room> getAll() {
        return null;
    }

    @Override
    public void addNew() {
        boolean check = true;
        while (check) {
            System.out.println("" +
                    "1.\t Add New Villa \n" +
                    "2.\t Add New House \n" +
                    "3.\t Add New Room \n" +
                    "4.\t Back to menu \n");
            System.out.println("nhap lua chon ban muon them vao ");
            int choice = new Choice().choice();
            switch (choice){
                case 1:new VillaServiceImpl().addNew();break;
                case 2:new HouseServiceImpl().addNew();break;
                case 3:new RoomServiceImpl().addNew();break;
                case 4:check=false;
                default:break;
            }
        }
    }

    @Override
    public void editData() {
        boolean check = true;
        while (check) {
            System.out.println("" +
                    "1.\t Edit Villa \n" +
                    "2.\t Edit House \n" +
                    "3.\t Edit Room \n" +
                    "4.\t Back to menu \n");
            System.out.println("nhap lua chon cua ban ");
            int choice = new Choice().choice();
            switch (choice) {
                case 1:new VillaServiceImpl().editData();break;
                case 2:new HouseServiceImpl().editData();break;
                case 3:new RoomServiceImpl().editData();break;
                case 4:check= false;
                default:break;
            }
        }
    }

    @Override
    public void disPlay() {
        new VillaServiceImpl().disPlay();
        new HouseServiceImpl().disPlay();
        new RoomServiceImpl().disPlay();
    }

    @Override
    public void displayFixData() {
        new VillaServiceImpl().displayFixData();
        new HouseServiceImpl().displayFixData();
        new RoomServiceImpl().displayFixData();
    }
}
