package _17_binaryFile.practise;

import java.util.ArrayList;
import java.util.List;

import static _17_binaryFile.practise.ReadAndWrite.writeToFile;

public class Run {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("src\\_17_binaryFile\\practise\\student.csv", students);
        List<Student> studentDataFromFile = ReadAndWrite.readDataFromFile("student.csv");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }
}
