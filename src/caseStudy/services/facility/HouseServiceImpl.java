package caseStudy.services.facility;

import caseStudy.DataStream.ReadAndWriteByteStream;
import caseStudy.Scan;
import caseStudy.controllers.Choice;
import caseStudy.models.facility.House;
import caseStudy.services.facility.Check.CheckTC;
import caseStudy.services.facility.Check.CheckValidateId;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HouseServiceImpl implements HouseService {
    private static final String filepath = "src\\caseStudy\\data\\House.csv";
    private static final ReadAndWriteByteStream<House> houseReadAndWrite = new ReadAndWriteByteStream<House>();
    private static Map<House, Integer> houseMap = new LinkedHashMap<>();

    @Override
    public Map<House, Integer> getAllHouse() {
        houseMap = houseReadAndWrite.readMapbyteStream(filepath);
        return houseMap;
    }

    @Override
    public List<House> getAll() {
        return null;
    }

    @Override
    public void addNew() {
        new HouseServiceImpl().getAllHouse();
        boolean check = false;
        String name = null;
        while (!check) {
            System.out.println(" nhap ma dich vu: House có dinh dang SVXX-YYYY, với YYYY là các số từ 0-9, XX là: HO vd: SVHO-0001 ");
            name = new Scan().input().nextLine();
            if (!houseMap.isEmpty()) {
                for (House house : houseMap.keySet()) {
                    if (!house.getUtilName().equals(name)) {
                        check = new CheckValidateId().checkIdNameHouse(name);
                        break;
                    }
                }
            } else {
                check = new CheckValidateId().checkIdNameHouse(name);
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
            System.out.println(" nhap tieu chuan phong co dinh dang TCHO-YY; YY la so tieu chuan; vd TCHO-01 ");
            roomStandard = new Scan().input().nextLine();
            check6 = new CheckTC().checkTChouse(roomStandard);
        }
        boolean check7 = true;
        int floors = 0;
        while (check7) {
            System.out.println(" nhap so tang phai la so > 0  ");
            floors = new Choice().choice();
            if (floors > 0) {
                check7 = false;
            }
        }
        House house2 = new House(name, useArea, rentalFees, maxNumsPeople, rentalType, roomStandard, floors);
        houseMap.put(house2, 0);
        houseReadAndWrite.writeMapByteStream(houseMap, filepath);
    }

    @Override
    public void editData() {
        new HouseServiceImpl().getAllHouse();
        boolean check = false;
        String name = null;
        while (!check) {
            System.out.println(" nhap ma dich vu ban mua sua: House có dinh dang SVXX-YYYY, với YYYY là các số từ 0-9, XX là: HO vd: SVHO-0001 ");
            name = new Scan().input().nextLine();
            check = new CheckValidateId().checkIdNameHouse(name);
        }
        for (House house : houseMap.keySet()) {
            if (house.getUtilName().equals(name)) {
                boolean checkedit = true;
                int useArea = house.getUseArea();
                int rentalFees = house.getRentalFees();
                int maxNumsPeople = house.getMaxNumsPeople();
                String rentalType = house.getRentalType();
                String roomStandard = house.getRoomStandard();
                int floors = house.getFloors();
                while (checkedit) {
                    System.out.println("ban muon sua thong tin cho " + house.toString());
                    System.out.println("1. nhap dien tich su dung  ");
                    System.out.println("2. nhap chi phi thue la so >0  ");
                    System.out.println("3. so nguoi toi da la 20 nguoi.");
                    System.out.println("4. Kiểu thuê co dinh dang XXX-YYYY :bao gồm thuê theo năm: Yea, tháng: Hou, ngày: Day, giờ: Hou; YYYY là các số từ 0-9 vd: Day-0001");
                    System.out.println("5. nhap tieu chuan phong co dinh dang TCHO-YY; YY la so tieu chuan; vd TCHO-01 ");
                    System.out.println("6. nhap so tang phai la so > 0  ");
                    System.out.println("7. Ket thuc chinh sua ");
                    System.out.println("nhap lua chon cua ban ");
                    int choice = new Choice().choice();
                    switch (choice) {
                        case 1: {
                            boolean check2 = true;
                            while (check2) {
                                System.out.println(" nhap dien tich su dung  ");
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
                                System.out.println(" Kiểu thuê co dinh dang XXX-YYYY :bao gồm thuê theo năm: Yea, tháng: Mon, ngày: Day, giờ: Hou; YYYY là các số từ 0-9 vd: Day-0001");
                                rentalType = new Scan().input().nextLine();
                                check5 = new CheckValidateId().checkDate(rentalType);
                            }
                            break;
                        }
                        case 5: {
                            boolean check6 = false;

                            while (!check6) {
                                System.out.println(" nhap tieu chuan phong co dinh dang TCHO-YY; YY la so tieu chuan; vd TCHO-01 ");
                                roomStandard = new Scan().input().nextLine();
                                check6 = new CheckTC().checkTChouse(roomStandard);
                            }
                            break;
                        }
                        case 6: {
                            boolean check7 = true;
                            while (check7) {
                                System.out.println(" nhap so tang phai la so > 0  ");
                                floors = new Choice().choice();
                                if (floors > 0) {
                                    check7 = false;
                                }
                            }
                            break;
                        }
                        case 7:
                            checkedit = false;
                        default:
                            break;
                    }
                }
                House house1 = new House(name, useArea, rentalFees, maxNumsPeople, rentalType, roomStandard, floors);
                int num = houseMap.get(house);
                houseMap.remove(house);
                houseMap.put(house1, num);
                break;
            }
        }
        houseReadAndWrite.clearData(filepath);
        houseReadAndWrite.writeMapByteStream(houseMap, filepath);
    }

    @Override
    public void disPlay() {
        new HouseServiceImpl().getAllHouse();
        Set<House> keySet = houseMap.keySet();
        for (House key : keySet) {
            System.out.println(key + " " + houseMap.get(key));
        }
    }

    @Override
    public void updateData(String idHouse) {
        new HouseServiceImpl().getAllHouse();
        boolean check = true;
        boolean checkId = false;
        while (check) {
            while (!checkId) {
                checkId = new CheckValidateId().checkIdNameHouse(idHouse);
            }
            for (House i : houseMap.keySet()) {
                if (i.getUtilName().equals(idHouse) && houseMap.get(i) < 5) {
                    int num = houseMap.get(i) + 1;
                    houseMap.replace(i, num);
                    check = false;
                    break;
                }
            }
        }
        houseReadAndWrite.clearData(filepath);
        houseReadAndWrite.writeMapByteStream(houseMap, filepath);
    }

    @Override
    public void fixData() {
        new HouseServiceImpl().getAllHouse();
        for (House i : houseMap.keySet()) {
            if (houseMap.get(i) == 5) {
                int num = 0;
                houseMap.replace(i, num);
                break;
            }
        }
        houseReadAndWrite.clearData(filepath);
        houseReadAndWrite.writeMapByteStream(houseMap, filepath);
    }

    @Override
    public void displayFixData() {
        new HouseServiceImpl().getAllHouse();
        for (House i : houseMap.keySet()) {
            if (houseMap.get(i) == 5) {
                System.out.println(i + "  " + houseMap.get(i));
            }
        }
    }

    public String checkDataBooking() {
        new HouseServiceImpl().getAllHouse();
        String id = null;
        boolean checkId = false;
        while (!checkId) {
            System.out.println("nhap idname House ban muon book voi dinh dang la SVHO-0001");
            id = new Scan().input().nextLine();
            for (House i : houseMap.keySet()) {
                if (i.getUtilName().equals(id) && houseMap.get(i) < 5) {
                    checkId = new CheckValidateId().checkIdNameHouse(id);
                }
            }
            if (!checkId) {
                System.out.println(id + " khong co trong danh sach hoac dang trong qua trinh bao trì!!!");
            }
        }
        return id;
    }
}
