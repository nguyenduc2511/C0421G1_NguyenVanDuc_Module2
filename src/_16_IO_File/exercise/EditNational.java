package _16_IO_File.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditNational {
    private static Scanner input = new Scanner(System.in);

    public List<National> readNational() {
        List<National> nationals = new ArrayList<>();
        List<String[]> listArr = new ReadAndWriteNational().readFile("src\\_16_IO_File\\data\\National.csv");
        for (String[] element : listArr) {
            National national = new National(Integer.parseInt(element[0]), element[1], element[2]);
            nationals.add(national);
            System.out.println(national.toString());
        }
        return nationals;
    }

    public void addNewNational() {
        System.out.println(" nhap id ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println(" nhap code ");
        String code = input.nextLine();
        System.out.println(" nhap name ");
        String name = input.nextLine();
        National national = new National(id, code, name);

        String line = national.getId() + "," + national.getCode() +"," + national.getName();

        new ReadAndWriteNational().writeFile("src\\_16_IO_File\\data\\National.csv", line);

    }

    public void removeNational() {
        System.out.println(" nhap id muon xoa ");
        int id = Integer.parseInt(input.nextLine());
        List<National> nationals = new ArrayList<>();
        List<String[]> listArr = new ReadAndWriteNational().readFile("src\\_16_IO_File\\data\\National.csv");
       String line ="";
        for (String[] element : listArr) {
            National national = new National(Integer.parseInt(element[0]), element[1], element[2]);
            if(id == Integer.parseInt(element[0])){
                line = national.getId() + "," + national.getCode() +"," + national.getName();
                break;
            }
        }
        new ReadAndWriteNational().removeData("src\\_16_IO_File\\data\\National.csv", line);
    }
}
