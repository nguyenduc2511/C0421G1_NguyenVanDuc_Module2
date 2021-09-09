package module2.case_Study.services.facility;


import module2.case_Study.dataCharacter.ReadAndWriteCharacterStream;
import module2.case_Study.models.facility.Villa;
import module2.case_Study.utils.CheckTC;
import module2.case_Study.utils.CheckValidateId;
import module2.case_Study.utils.Choice;
import module2.case_Study.utils.Scan;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VillaServiceImpl implements VillaService {
    private static final String filepath = "src\\module2\\case_Study\\data\\Villa.csv";
    public static final ReadAndWriteCharacterStream readAndWrite = new ReadAndWriteCharacterStream();
    private static final Map<Villa, Integer> villaMap = new LinkedHashMap<>();

    @Override
    public List<Villa> getAll() {
        return null;
    }

    @Override
    public Map<Villa, Integer> getAllVilla() {
        List<String[]> list = readAndWrite.readFile(filepath);
        villaMap.clear();
        for (String[] element : list) {
            Villa villa = new Villa(element[0], Integer.parseInt(element[1]), Integer.parseInt(element[2]),
                    Integer.parseInt(element[3]), element[4], element[5], Integer.parseInt(element[6]), Integer.parseInt(element[7]));
            int value = Integer.parseInt(element[8]);
            villaMap.put(villa,value);
        }
        return villaMap;
    }

    @Override
    public void updateData(String idVilla) {
        new VillaServiceImpl().getAllVilla();
        boolean check = true;
        boolean checkId = false;
        while (check) {
            while (!checkId) {
                checkId = new CheckValidateId().checkIdNameVilla(idVilla);
            }
            for (Villa i : villaMap.keySet()) {
                if (i.getUtilName().equals(idVilla) && villaMap.get(i) < 5) {
                    int num = villaMap.get(i) + 1;
                    villaMap.replace(i, num);
                    check = false;
                    break;
                }
            }
        }


    }
    public void updateDataLow(String idVilla) {
        new VillaServiceImpl().getAllVilla();
        boolean check = true;
        boolean checkId = false;
        while (check) {
            while (!checkId) {
                checkId = new CheckValidateId().checkIdNameVilla(idVilla);
            }
            for (Villa i : villaMap.keySet()) {
                if (i.getUtilName().equals(idVilla) && villaMap.get(i) < 5) {
                    int num = villaMap.get(i) - 1;
                    villaMap.replace(i, num);
                    check = false;
                    break;
                }
            }
        }


    }
    @Override
    public void fixData() {
        new VillaServiceImpl().getAllVilla();
        for (Villa i : villaMap.keySet()) {
            if (villaMap.get(i) < 5) {
                int num = 0;
                villaMap.replace(i, num);
            }
        }


    }

    @Override
    public void displayFixData() {
        new VillaServiceImpl().getAllVilla();
        for (Villa i : villaMap.keySet()) {
            if (villaMap.get(i) == 5) {
                System.out.println(i + " " + villaMap.get(i));
            }
        }
    }

    @Override
    public void addNew() {
        new VillaServiceImpl().getAllVilla();
        boolean check = false;
        String name = null;
        while (!check) {
            System.out.println(" nhap ma dich vu: Villa có dinh dang SVXX-YYYY, với YYYY là các số từ 0-9, XX là: VL vd: SVVL-0001 ");
            name = new Scan().input().nextLine();
            if (!villaMap.isEmpty()) {
                for (Villa villa : villaMap.keySet()) {
                    if (!villa.getUtilName().equals(name)) {
                        check = new CheckValidateId().checkIdNameVilla(name);
                        break;
                    }
                }
            } else {
                check = new CheckValidateId().checkIdNameVilla(name);
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
            System.out.println(" nhap chi phi thue la so >0  ");
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
            System.out.println(" Kiểu thuê co dinh dang XXX-YYYY :bao gồm thuê theo năm: Yea, tháng: Mon, ngày: Day, giờ: Hou; YYYY là các số từ 0-9 vd: Day-0001");
            rentalType = new Scan().input().nextLine();
            check5 = new CheckValidateId().checkDate(rentalType);
        }
        boolean check6 = false;
        String roomStandard = null;
        while (!check6) {
            System.out.println(" nhap tieu chuan phong co dinh dang TCVL-YY; YY la so tieu chuan; vd TCVL-01 ");
            roomStandard = new Scan().input().nextLine();
            check6 = new CheckTC().checkTCVilla(roomStandard);
        }
        boolean check7 = true;
        int poolArea = 0;
        while (check7) {
            System.out.println(" nhap dien tich ho boi >30 ");
            poolArea = new Choice().choice();
            if (poolArea >= 30) {
                check7 = false;
            }
        }
        boolean check8 = true;
        int floors = 0;
        while (check8) {
            System.out.println(" nhap so tang phai la so > 0  ");
            floors = new Choice().choice();
            if (floors > 0) {
                check8 = false;
            }
        }
        Villa villa2 = new Villa(name, useArea, rentalFees, maxNumsPeople, rentalType, roomStandard, poolArea, floors);
        int value=0;
        villaMap.put(villa2, value);
        String line = villa2.getUtilName()+","+villa2.getUseArea()+","+villa2.getRentalFees()+","+villa2.getMaxNumsPeople()
                +","+villa2.getRentalType()+","+villa2.getRoomStandard()+","+villa2.getPoolArea()+","+villa2.getFloors()+","+villaMap.get(villa2);
        readAndWrite.writeData(filepath, line);
    }

    @Override
    public void editData() {
        new VillaServiceImpl().getAllVilla();
        new VillaServiceImpl().disPlay();
        boolean check = false;
        String name = null;
        String lineLocation = "";
        String line = "";
        boolean checkFinal = true;
        while (!check) {
            System.out.println(" nhap ma dich vu ban mua sua: Villa có dinh dang SVXX-YYYY, với YYYY là các số từ 0-9, XX là: VL vd: SVVL-0001 ");
            name = new Scan().input().nextLine();
            check = new CheckValidateId().checkIdNameVilla(name);
        }
        int value=0;
        for (Villa villa : villaMap.keySet()) {
            if (villa.getUtilName().equals(name)) {
                value = villaMap.get(villa);
                 lineLocation = villa.getUtilName()+","+villa.getUseArea()+","+villa.getRentalFees()+","+villa.getMaxNumsPeople()
                        +","+villa.getRentalType()+","+villa.getRoomStandard()+","+villa.getPoolArea()+","+villa.getFloors()+","+value;
                boolean checkedit = true;
                while (checkedit) {
                    System.out.println("ban muon sua thong tin cho " + villa.toString());
                    System.out.println("1. nhap dien tich su dung  ");
                    System.out.println("2. nhap chi phi thue la so >0  ");
                    System.out.println("3. so nguoi toi da la 20 nguoi.");
                    System.out.println("4. Kiểu thuê co dinh dang XXX-YYYY :bao gồm thuê theo năm: Yea, tháng: Mon, ngày: Day, giờ: Hou; YYYY là các số từ 0-9 vd: Day-0001");
                    System.out.println("5. nhap tieu chuan phong co dinh dang TCVL-YY; YY la so tieu chuan; vd TCVL-01 ");
                    System.out.println("6. nhap dien tich ho boi >30 ");
                    System.out.println("7. nhap so tang phai la so > 0  ");
                    System.out.println("8. Ket thuc chinh sua ");
                    System.out.println("nhap lua chon cua ban ");
                    int choice = new Choice().choice();
                    switch (choice) {
                        case 1: {
                            boolean check2 = true;
                            int useArea = 0;
                            while (check2) {
                                System.out.println(" nhap dien tich su dung phai lon hon 30 ");
                                 useArea = new Choice().choice();
                                if (useArea >= 30) {
                                    check2 = false;
                                }
                            }
                           villa.setUseArea(useArea);
                            break;
                        }
                        case 2: {
                            boolean check3 = true;
                            int rentalFees=0;
                            while (check3) {
                                System.out.println(" nhap chi phi thue la so >0  ");
                                rentalFees = new Choice().choice();
                                if (rentalFees > 0) {
                                    check3 = false;
                                }
                            }
                            villa.setRentalFees(rentalFees);
                            break;
                        }
                        case 3: {
                            boolean check4 = true;
                            int maxNumsPeople=0;
                            while (check4) {
                                System.out.println("so nguoi toi da la 20 nguoi.");
                                maxNumsPeople = new Choice().choice();
                                if (maxNumsPeople <= 20 && maxNumsPeople > 0) {
                                    check4 = false;
                                }
                            }
                            villa.setMaxNumsPeople(maxNumsPeople);
                            break;
                        }
                        case 4: {
                            boolean check5 = false;
                            String rentalType = "";
                            while (!check5) {
                                System.out.println(" Kiểu thuê co dinh dang XXX-YYYY :bao gồm thuê theo năm: Yea, tháng: Mon, ngày: Day, giờ: Hou; YYYY là các số từ 0-9 vd: Day-0001");
                                rentalType = new Scan().input().nextLine();
                                check5 = new CheckValidateId().checkDate(rentalType);
                            }
                            villa.setRentalType(rentalType);
                            break;
                        }
                        case 5: {
                            boolean check6 = false;
                            String roomStandard="";
                            while (!check6) {
                                System.out.println(" nhap tieu chuan phong co dinh dang TCVL-YY; YY la so tieu chuan; vd TCVL-01 ");
                                roomStandard = new Scan().input().nextLine();
                                check6 = new CheckTC().checkTCVilla(roomStandard);
                            }
                            villa.setRoomStandard(roomStandard);
                            break;
                        }
                        case 6: {
                            boolean check7 = true;
                            int poolArea=0;
                            while (check7) {
                                System.out.println(" nhap dien tich ho boi >30 ");
                                poolArea = new Choice().choice();
                                if (poolArea >= 30) {
                                    check7 = false;
                                }
                            }
                            villa.setPoolArea(poolArea);
                            break;
                        }
                        case 7: {
                            boolean check7 = true;
                            int floors=0;
                            while (check7) {
                                System.out.println(" nhap so tang phai la so > 0  ");
                                floors = new Choice().choice();
                                if (floors > 0) {
                                    check7 = false;
                                }
                            }
                            villa.setFloors(floors);
                            break;
                        }
                        case 8:
                            checkedit = false;
                            break;
                        default:
                            System.out.println("nhap lua chon dung ");
                            break;
                    }
                }
                line = villa.getUtilName()+","+villa.getUseArea()+","+villa.getRentalFees()+","+villa.getMaxNumsPeople()
                        +","+villa.getRentalType()+","+villa.getRoomStandard()+","+villa.getPoolArea()+","+villa.getFloors()+","+value;
                 checkFinal = false;
                break;
            }
        }
        if (checkFinal) {
            System.out.println("khong tim thay id ban vua nhap");
        }
        readAndWrite.editData(filepath, lineLocation, line);

    }

    @Override
    public void disPlay() {
        new VillaServiceImpl().getAllVilla();
        Set<Villa> keySet = villaMap.keySet();
        for (Villa key : keySet) {
            System.out.println(key + " " + villaMap.get(key));
        }
    }

    public String checkDataBooking() {
        new VillaServiceImpl().getAllVilla();
        String id = null;
        boolean checkId = false;
        while (!checkId) {
            System.out.println("nhap idname Villa ban muon book voi dinh dang la SVVL-0001");
            id = new Scan().input().nextLine();
            for (Villa i : villaMap.keySet()) {
                if (i.getUtilName().equals(id) && villaMap.get(i) < 5) {
                    checkId = new CheckValidateId().checkIdNameVilla(id);
                }
            }
            if (!checkId) {
                System.out.println(id + " khong co trong danh sach hoac dang trong qua trinh bao trì!!!");
            }
        }
        return id;
    }
}
