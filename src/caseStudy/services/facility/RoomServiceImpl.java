package caseStudy.services.facility;

import caseStudy.DataStream.ReadAndWriteByteStream;
import caseStudy.Scan;
import caseStudy.controllers.Choice;
import caseStudy.models.facility.Room;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class RoomServiceImpl implements RoomService{
    private static final String filepath = "src\\caseStudy\\data\\Room.csv";
    private static final ReadAndWriteByteStream<Room> roomReadAndWrite = new ReadAndWriteByteStream<Room>();
    private static Map<Room, Integer> roomMap = new LinkedHashMap<>();

    @Override
    public Map<Room, Integer> getAllRoom() {
        roomMap = roomReadAndWrite.readMapbyteStream(filepath);
        return roomMap;
    }
    @Override
    public List<Room> getAll() {
        return null;
    }
    private static boolean validateRoom(String string) {
        boolean checkPatten = false;
        String regexCheck = "^[S][V][R][O][-]\\d{4}$";
        String regexCheck2 = "^[D][a][y][-]\\d{4}$";
        String regexCheck3 = "^[M][o][n][-]\\d{4}$";
        String regexCheck4 = "^[Y][e][a][-]\\d{4}$";
        String regexCheck5 = "^[H][o][u][-]\\d{4}$";
        String regexCheck6 = "^[T][C][H][O][-]\\d{2}$";
        if (Pattern.matches(regexCheck, string)) {
            checkPatten = true;
        }
        if (Pattern.matches(regexCheck2, string)) {
            checkPatten = true;
        }
        if (Pattern.matches(regexCheck3, string)) {
            checkPatten = true;
        }
        if (Pattern.matches(regexCheck4, string)) {
            checkPatten = true;
        }
        if (Pattern.matches(regexCheck5, string)) {
            checkPatten = true;
        }
        if (Pattern.matches(regexCheck6, string)) {
            checkPatten = true;
        }
        return checkPatten;
    }
    @Override
    public void addNew() {
        new RoomServiceImpl().getAllRoom();
        boolean check = false;
        String name = null;
        while (!check) {
            System.out.println(" nhap ma dich vu: Room có dinh dang SVXX-YYYY, với YYYY là các số từ 0-9, XX là: RO vd: SVRO-0001");
            name = new Scan().input().nextLine();
            check = validateRoom(name);
        }
        boolean check2 = true;
        int useArea = 0;
        while (check2) {
            System.out.println(" nhap dien tich su dung >30 ");
            useArea = new Choice().choice();
            if (useArea >= 30) {
                check2 = false;
            }
        }
        boolean check3 = true;
        int rentalFees = 0;
        while (check3) {
            System.out.println(" nhap dien tich su dung phai la so >0  ");
            rentalFees = new Choice().choice();
            if (rentalFees > 0) {
                check3 = false;
            }
        }
        boolean check4 = true;
        int maxNumsPeople = 0;
        while (check4) {
            System.out.println("so nguoi toi da la 20 nguoi.");
            maxNumsPeople = new Choice().choice();
            if (maxNumsPeople <= 20 && maxNumsPeople > 0) {
                check4 = false;
            }
        }
        boolean check5 = false;
        String rentalType = null;
        while (!check5) {
            System.out.println(" Kiểu thuê co dinh dang XXX-YYYY :bao gồm thuê theo năm: Yea, tháng: Hou, ngày: Day, giờ: Hou; YYYY là các số từ 0-9 vd: Day-0001");
            rentalType = new Scan().input().nextLine();
            check5 = validateRoom(rentalType);
        }
        System.out.println("nhap dich vu mien phi di kem room");
        String free = new Scan().input().nextLine();
        Room room2 = new Room(name, useArea, rentalFees, maxNumsPeople, rentalType,free);
        roomMap.put(room2,0);
        roomReadAndWrite.writeMapByteStream(roomMap, filepath);
    }

    @Override
    public void editData() {
        new RoomServiceImpl().getAllRoom();
        boolean check = false;
        String name = null;
        while (!check) {
            System.out.println(" nhap ma dich vu: Room có dinh dang SVXX-YYYY, với YYYY là các số từ 0-9, XX là: RO vd: SVRO-0001");
            name = new Scan().input().nextLine();
            check = validateRoom(name);
        }
        for(Room roomEdit : roomMap.keySet()){
            if(roomEdit.getUtilName().equals(name)){
                boolean checkedit = true;
                int useArea =  roomEdit.getUseArea();
                int rentalFees =  roomEdit.getRentalFees();
                int maxNumsPeople = roomEdit.getMaxNumsPeople();
                String rentalType = roomEdit.getRentalType();
                String free = roomEdit.getFreeServices();
                while (checkedit){
                    System.out.println("ban muon sua thong tin cho " + roomEdit.toString());
                    System.out.println("1. nhap dien tich su dung >30 ");
                    System.out.println("2. nhap chi phi thue la so >0  ");
                    System.out.println("3. so nguoi toi da la 20 nguoi.");
                    System.out.println("4. Kiểu thuê co dinh dang XXX-YYYY :bao gồm thuê theo năm: Yea, tháng: Hou, ngày: Day, giờ: Hou; YYYY là các số từ 0-9 vd: Day-0001");
                    System.out.println("5. dich vu mien phi di kem ");
                    System.out.println("6. Ket thuc chinh sua ");
                    System.out.println("nhap lua chon cua ban ");
                    int choice = new Choice().choice();
                    switch (choice){
                        case 1:{
                            boolean check2 = true;
                            while (check2) {
                                System.out.println(" nhap dien tich su dung >30  ");
                                useArea = new Choice().choice();
                                if (useArea >= 30) {
                                    check2 = false;
                                }
                            }
                            break;
                        }
                        case 2:{
                            boolean check3 = true;

                            while (check3) {
                                System.out.println(" nhap chi phi thue la so >0  ");
                                rentalFees = new Choice().choice();
                                if (rentalFees > 0) {
                                    check3 = false;
                                }
                            }
                            break;
                        }
                        case 3:{
                            boolean check4 = true;

                            while (check4) {
                                System.out.println("so nguoi toi da la 20 nguoi.");
                                maxNumsPeople = new Choice().choice();
                                if (maxNumsPeople <= 20 && maxNumsPeople > 0) {
                                    check4 = false;
                                }
                            }
                            break;
                        }
                        case 4:{
                            boolean check5 = false;
                            while (!check5) {
                                System.out.println(" Kiểu thuê co dinh dang XXX-YYYY :bao gồm thuê theo năm: Yea, tháng: Mon, ngày: Day, giờ: Hou; YYYY là các số từ 0-9 vd: Day-0001");
                                rentalType = new Scan().input().nextLine();
                                check5 = validateRoom(rentalType);
                            }
                            break;
                        }
                        case 5:{
                            System.out.println("nhap dich vu mien phi di kem room");
                             free = new Scan().input().nextLine();
                            break;
                        }
                        case 6:checkedit=false;
                        default:break;
                    }
                }
                Room room1 = new Room(name, useArea, rentalFees, maxNumsPeople, rentalType, free);
                roomMap.remove(roomEdit);
                roomMap.put(room1,0);
                break;
            }
        }
        roomReadAndWrite.clearData(filepath);
        roomReadAndWrite.writeMapByteStream(roomMap,filepath);
    }

    @Override
    public void disPlay() {
        new RoomServiceImpl().getAllRoom();
        Set<Room> keySet = roomMap.keySet();
        for (Room key : keySet) {
            System.out.println(key + " " + roomMap.get(key));
        }
    }


}
