package _16_IO_File.exercise;

import java.util.Scanner;

public class CopyFileTest {
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file muon copy : src\\_16_IO_File\\data\\number.csv ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println("Nhập đường dẫn file muon past : src\\_16_IO_File\\data\\number2.csv ");
        String path2 = scanner.nextLine();
        CopyFile copyFile =new CopyFile();
        copyFile.copyfile(path,path2);
        copyFile.printFile(path2);
    }
}
