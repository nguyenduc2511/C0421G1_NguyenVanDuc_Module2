package reviewBaiTapATrung;

import _16_IO_File.exercise.National;
import _16_IO_File.exercise.ReadAndWriteNational;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CotrollerStudent {
    private static final String filePath = "src\\reviewBaiTapATrung\\data\\Student.csv";

    private static Scanner input = new Scanner(System.in);

    public List<Student> readStudent(){
        List<Student> studentList = new ArrayList<>();
        List<String[]> list = new ReadAndWriteStudent().readFile(filePath);
        for (String[] element : list) {
            Student student = new Student(Integer.parseInt(element[0]),element[1],Integer.parseInt(element[2]),element[3]);
            studentList.add(student);
            System.out.println(student.toString());
        }
        return studentList;
    }

    public void addNewStudent(){
        System.out.println(" nhap id ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println(" nhap ten  ");
        String name = input.nextLine();
        System.out.println(" nhap tuoi ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println(" dia chi ");
        String address = input.nextLine();
        Student student = new Student(id,name,age,address);

        String line = student.getId()+","+student.getName()+","+student.getAge()+","+student.getAddress();
        new ReadAndWriteStudent().writeData(filePath,line);
    }
    public void removeStudent() {
        System.out.println(" nhap id muon xoa ");
        int id = Integer.parseInt(input.nextLine());
        List<String[]> listArr = new ReadAndWriteStudent().readFile(filePath);
        String line ="";
        for (String[] element : listArr) {
            Student student = new Student(Integer.parseInt(element[0]), element[1], Integer.parseInt(element[2]),element[3]);
            if(id == Integer.parseInt(element[0])){
                line = student.getId() + "," + student.getName() +"," + student.getAge()+","+student.getAddress();
                new ReadAndWriteNational().removeData(filePath, line);
            }
        }

    }
    public void editStudent(){
        System.out.println(" nhap id ban muon sua thong tin ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println(" nhap ten  ");
        String name = input.nextLine();
        System.out.println(" nhap tuoi ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println(" dia chi ");
        String address = input.nextLine();
        List<String[]> listArr = new ReadAndWriteStudent().readFile(filePath);
        String lineLocation ="";
        String lineEdit = id+","+name+","+age+","+address;
        for (String[] element : listArr) {
            Student student = new Student(Integer.parseInt(element[0]), element[1], Integer.parseInt(element[2]),element[3]);
            if(id == Integer.parseInt(element[0] )){
                lineLocation = student.getId() + "," + student.getName() +"," + student.getAge()+","+student.getAddress();
                new ReadAndWriteStudent().editData(filePath,lineLocation,lineEdit);
            }
        }

    }

}
