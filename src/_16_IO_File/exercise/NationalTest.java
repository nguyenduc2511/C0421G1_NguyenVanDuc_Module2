package _16_IO_File.exercise;

import java.util.Scanner;

public class NationalTest {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean check = true;
        while (check){
            System.out.println("1. them moi national");
            System.out.println("2. hien thi danh sach national");
            System.out.println("3. xoa data trong file theo id ");
            System.out.println("4. thoat ung dung ");
            System.out.println("hay nhap lua chon");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    new EditNational().addNewNational();
                    break;
                case 2:
                    new EditNational().readNational();
                    break;
                case 3:
                   new EditNational().removeNational();
                    break;
                case 4:
                    check = false;
                    break;
            }

        }
    }
}
