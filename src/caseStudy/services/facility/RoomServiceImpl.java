package caseStudy.services.facility;

import caseStudy.DataStream.ReadAndWriteByteStream;
import caseStudy.models.facility.Room;
import caseStudy.utils.CheckValidateId;
import caseStudy.utils.Choice;
import caseStudy.utils.Scan;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RoomServiceImpl implements RoomService {
    private static final String filepath = "src\\caseStudy\\data\\Room.csv";
    private static final ReadAndWriteByteStream<Room> roomReadAndWrite = new ReadAndWriteByteStream<Room>();
    private static Map<Room, Integer> roomMap = new LinkedHashMap<>();

    @Override
    public Map<Room, Integer> getAllRoom() {
        roomMap = roomReadAndWrite.readMapbyteStream(filepath);
        return roomMap;
    }

    @Override
    public void updateData(String idRoom) {
        new RoomServiceImpl().getAllRoom();
        boolean check = true;
        boolean checkId = false;
        while (check) {
            while (!checkId) {
                checkId = new CheckValidateId().checkIdNameRoom(idRoom);
            }
            for (Room i : roomMap.keySet()) {
                if (i.getUtilName().equals(idRoom) && roomMap.get(i) < 5) {
                    int num = roomMap.get(i) + 1;
                    roomMap.replace(i, num);
                    check = false;
                    break;
                }
            }
        }
        roomReadAndWrite.clearData(filepath);
        roomReadAndWrite.writeMapByteStream(roomMap, filepath);
    }
    public void updateDataLow(String idRoom) {
        new RoomServiceImpl().getAllRoom();
        boolean check = true;
        boolean checkId = false;
        while (check) {
            while (!checkId) {
                checkId = new CheckValidateId().checkIdNameRoom(idRoom);
            }
            for (Room i : roomMap.keySet()) {
                if (i.getUtilName().equals(idRoom) && roomMap.get(i) < 5) {
                    int num = roomMap.get(i) - 1;
                    roomMap.replace(i, num);
                    check = false;
                    break;
                }
            }
        }
        roomReadAndWrite.clearData(filepath);
        roomReadAndWrite.writeMapByteStream(roomMap, filepath);
    }
    @Override
    public void fixData() {
        new RoomServiceImpl().getAllRoom();
        for (Room i : roomMap.keySet()) {
            if (roomMap.get(i) == 5) {
                int num = 0;
                roomMap.replace(i, num);
                break;
            }
        }
        roomReadAndWrite.clearData(filepath);
        roomReadAndWrite.writeMapByteStream(roomMap, filepath);
    }


    @Override
    public void displayFixData() {
        new RoomServiceImpl().getAllRoom();
        for (Room i : roomMap.keySet()) {
            if (roomMap.get(i) == 5) {
                System.out.println(i + " " + roomMap.get(i));
            }
        }
    }

    @Override
    public List<module2.case_Study.models.facility.Room> getAll() {
        return null;
    }

    @Override
    public void addNew() {
        new RoomServiceImpl().getAllRoom();
        boolean check = false;
        String name = null;
        while (!check) {
            System.out.println(" nhap ma dich vu: Room c?? dinh dang SVXX-YYYY, v???i YYYY l?? c??c s??? t??? 0-9, XX l??: RO vd: SVRO-0001");
            name = new Scan().input().nextLine();
            if (!roomMap.isEmpty()) {
                for (Room room : roomMap.keySet()) {
                    if (!room.getUtilName().equals(name)) {
                        check = new CheckValidateId().checkIdNameRoom(name);
                        break;
                    }
                }
            } else {
                check = new CheckValidateId().checkIdNameRoom(name);
            }
            if (!check) {
                System.out.println("trung ma dich vu " + name + " vui long nhap lai ");
            }
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
            System.out.println(" nhap ch phi the phai la so >0  ");
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
            System.out.println(" Ki???u thu?? co dinh dang XXX-YYYY :bao g???m thu?? theo n??m: Yea, th??ng: Mon, ng??y: Day, gi???: Hou; YYYY l?? c??c s??? t??? 0-9 vd: Day-0001");
            rentalType = new Scan().input().nextLine();
            check5 = new CheckValidateId().checkDate(rentalType);
        }
        System.out.println("nhap dich vu mien phi di kem room");
        String free = new Scan().input().nextLine();
        Room room2 = new Room(name, useArea, rentalFees, maxNumsPeople, rentalType, free);
        roomMap.put(room2, 0);
        roomReadAndWrite.writeMapByteStream(roomMap, filepath);
    }

    @Override
    public void editData() {
        new RoomServiceImpl().getAllRoom();
        boolean check = false;
        String name = null;
        while (!check) {
            System.out.println(" nhap ma dich vu: Room c?? dinh dang SVXX-YYYY, v???i YYYY l?? c??c s??? t??? 0-9, XX l??: RO vd: SVRO-0001");
            name = new Scan().input().nextLine();
            check = new CheckValidateId().checkIdNameRoom(name);
        }
        for (Room roomEdit : roomMap.keySet()) {
            if (roomEdit.getUtilName().equals(name)) {
                boolean checkedit = true;
                int useArea = roomEdit.getUseArea();
                int rentalFees = roomEdit.getRentalFees();
                int maxNumsPeople = roomEdit.getMaxNumsPeople();
                String rentalType = roomEdit.getRentalType();
                String free = roomEdit.getFreeServices();
                while (checkedit) {
                    System.out.println("ban muon sua thong tin cho " + roomEdit.toString());
                    System.out.println("1. nhap dien tich su dung >30 ");
                    System.out.println("2. nhap chi phi thue la so >0  ");
                    System.out.println("3. so nguoi toi da la 20 nguoi.");
                    System.out.println("4. Ki???u thu?? co dinh dang XXX-YYYY :bao g???m thu?? theo n??m: Yea, th??ng: Mon, ng??y: Day, gi???: Hou; YYYY l?? c??c s??? t??? 0-9 vd: Day-0001");
                    System.out.println("5. dich vu mien phi di kem ");
                    System.out.println("6. Ket thuc chinh sua ");
                    System.out.println("nhap lua chon cua ban ");
                    int choice = new Choice().choice();
                    switch (choice) {
                        case 1: {
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
                        case 2: {
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
                        case 3: {
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
                        case 4: {
                            boolean check5 = false;
                            while (!check5) {
                                System.out.println(" Ki???u thu?? co dinh dang XXX-YYYY :bao g???m thu?? theo n??m: Yea, th??ng: Mon, ng??y: Day, gi???: Hou; YYYY l?? c??c s??? t??? 0-9 vd: Day-0001");
                                rentalType = new Scan().input().nextLine();
                                check5 = new CheckValidateId().checkDate(rentalType);
                            }
                            break;
                        }
                        case 5: {
                            System.out.println("nhap dich vu mien phi di kem room");
                            free = new Scan().input().nextLine();
                            break;
                        }
                        case 6:
                            checkedit = false;
                        default:
                            break;
                    }
                }
                Room room1 = new Room(name, useArea, rentalFees, maxNumsPeople, rentalType, free);
                roomMap.remove(roomEdit);
                roomMap.put(room1, 0);
                break;
            }
        }
        roomReadAndWrite.clearData(filepath);
        roomReadAndWrite.writeMapByteStream(roomMap, filepath);
    }

    @Override
    public void disPlay() {
        new RoomServiceImpl().getAllRoom();
        Set<Room> keySet = roomMap.keySet();
        for (Room key : keySet) {
            System.out.println(key + " " + roomMap.get(key));
        }
    }

    public String checkDataBooking() {
        new RoomServiceImpl().getAllRoom();
        String id = null;
        boolean checkId = false;
        while (!checkId) {
            System.out.println("nhap idname ban muon book");
            id = new Scan().input().nextLine();
            for (Room i : roomMap.keySet()) {
                if (i.getUtilName().equals(id) && roomMap.get(i) < 5) {
                    checkId = new CheckValidateId().checkIdNameRoom(id);
                }
            }
            if (!checkId) {
                System.out.println(id + "khong co trong danh sach hoac dang trong qua trinh bao tr??!!!");
            }
        }
        return id;
    }
}
