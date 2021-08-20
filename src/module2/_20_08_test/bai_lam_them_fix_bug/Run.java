package module2._20_08_test.bai_lam_them_fix_bug;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        boolean check = true;
        while (check) {
            System.out.println("Chọn chức năng\n" +
                    "1.Add\n" +
                    "2.show\n" + "3.Edit\n"+"4.Delete\n"+"5.Find\n"+
                    "6.Exit");
            System.out.println("Chọn");
            Scanner scanner = new Scanner(System.in);
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    StudentManager.add();
                    break;
                case 2:
                    StudentManager.display();
                    break;
                case 3:
                    StudentManager.edit();
                    break;
                case 4:
                    StudentManager.delete();
                    break;
                case 5:
                    StudentManager.find();
                    break;
                case 6:
                    check = false;
                    break;
                default:
                    System.out.println("nhap dung so lua chon");
                    break;
            }
        }
    }
}
