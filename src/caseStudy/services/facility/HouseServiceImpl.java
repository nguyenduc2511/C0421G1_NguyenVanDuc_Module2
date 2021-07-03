package caseStudy.services.facility;

import caseStudy.DataStream.ReadAndWriteByteStream;
import caseStudy.Scan;
import caseStudy.controllers.Choice;
import caseStudy.models.facility.House;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class HouseServiceImpl implements HouseService {
    private static final String filepath = "src\\caseStudy\\data\\House.csv";
    private static final ReadAndWriteByteStream<House> houseReadAndWrite = new ReadAndWriteByteStream<House>();
    private static Map<House, Integer> houseMap = new LinkedHashMap<>();

    @Override
    public Map<House, Integer> getAllHouse() {
//        List<House> houses = houseReadAndWrite.readFileByteStream(filepath);
//        for (House house : houses) {
//            houseMap.put(house, 0);
//        }
//        return houseMap;

    }

    @Override
    public List<House> getAll() {
        return null;
    }

    private static boolean validateidHouse(String string) {
        boolean checkPatten = false;
        String regexCheck = "^[S][V][H][O][-]\\d{4}$";
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
        new HouseServiceImpl().getAllHouse();
        boolean check = false;
        String name = null;
        while (!check) {
            System.out.println(" nhap ma dich vu: House có dinh dang SVXX-YYYY, với YYYY là các số từ 0-9, XX là: HO ");
             name = new Scan().input().nextLine();
            check = validateidHouse(name);
        }
        boolean check2 = true;
        int useArea=0;
        while (check2) {
            System.out.println(" nhap dien tich su dung  ");
            useArea = new Choice().choice();
            if (useArea >= 30) {
                check2 = false;
            }
        }
        boolean check3 = true;
        int rentalFees=0;
        while (check3) {
            System.out.println(" nhap dien tich su dung phai la so >0  ");
            rentalFees = new Choice().choice();
            if (rentalFees > 0) {
                check3 = false;
            }
        }
        boolean check4 = true;
        int maxNumsPeople=0 ;
        while (check4) {
            System.out.println("so nguoi toi da la 20 nguoi.");
            maxNumsPeople = new Choice().choice();
            if (maxNumsPeople <= 20 && maxNumsPeople > 0) {
                check4 = false;
            }
        }
        boolean check5 = false;
        String rentalType=null;
        while (!check5) {
            System.out.println(" Kiểu thuê co dinh dang XXX-YYYY :bao gồm thuê theo năm: Yea, tháng: Hou, ngày: Day, giờ: Hou; YYYY là các số từ 0-9 vd: Day-0001");
             rentalType = new Scan().input().nextLine();
            check5 = validateidHouse(rentalType);
        }
        boolean check6 = false;
        String roomStandard=null;
        while (!check6) {
            System.out.println(" nhap tieu chuan phong co dinh dang TCHO-YY; YY la so tieu chuan; vd TCH-O01 ");
             roomStandard = new Scan().input().nextLine();
            check6 = validateidHouse(roomStandard);
        }
        boolean check7 = true;
        int floors=0;
        while (check7) {
            System.out.println(" nhap so tang phai la so > 0  ");
             floors = new Choice().choice();
            if (floors > 0) {
                check7 = false;
            }
        }
        House house2 = new House(name,useArea,rentalFees,maxNumsPeople,rentalType,roomStandard,floors);
       List<House> list = null;
       list.add(house2);

        houseReadAndWrite.writeFileByteStream(list, filepath);

    }

    @Override
    public void editData() {

    }

    @Override
    public void disPlay() {
        Set<House> keySet = houseMap.keySet();
        for (House key : keySet) {
            System.out.println(key + " " + houseMap.get(key));
        }
    }


}
