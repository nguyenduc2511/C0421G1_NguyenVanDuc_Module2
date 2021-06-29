package reviewBaiTapATrung;

import java.util.Scanner;

public class demoQuanLySinhVien {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("------chuong tirnh quan ly sinh vien------");
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
//                    hiển thị danh sách sinh viên
                    new CotrollerStudent().readStudent();
                    break;
                case 2:
//                    xóa tên sinh viên
                    new CotrollerStudent().removeStudent();
                    break;
                case 3:
//                    sua ten trong danh sach
                    new CotrollerStudent().editStudent();
                    break;
                case 4:
//                    thêm mới học viên
                   new CotrollerStudent().addNewStudent();
                    break;
                case 5:
                    System.out.println("thoat danh sach sinh vien");
                    System.exit(0);
                default:
                    System.out.println("moi ban nhap lai ");
            }
        }
    }
    public static void displayMenu() {
        System.out.println("1. xem danh sach sinh vien");
        System.out.println("2. xoa sinh vien ");
        System.out.println("3. chinh sua thong tin sinh vien ");
        System.out.println("4. them moi sinh vien ");
        System.out.println("5. thoat khoi chuong trinh");
        System.out.println("chon chuc nang su dung: ");
    }
}

