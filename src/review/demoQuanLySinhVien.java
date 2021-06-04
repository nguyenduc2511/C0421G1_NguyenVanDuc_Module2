package review;

import java.util.Scanner;

public class demoQuanLySinhVien {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] students = new String[50];
        System.out.println("------chuong tirnh quan ly sinh vien------");
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
//                    hiển thị danh sách sinh viên
                    displayListStudent(students);
                    break;
                case 2:
//                    xóa tên sinh viên
                    deleteStudent(students);
                    break;
                case 3:
//                    sua ten trong danh sach
                    editStudent(students);
                    break;
                case 4:
//                    thêm mới học viên
                    addNewStudent(students);
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

    public static void displayListStudent(String[] students) {
//        hien thi danh sach sv
        System.out.println("hien thi danh sach sinh vien");
        for (String student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    public static void deleteStudent(String[] student) {
        System.out.println("code xoa ten sinh vien");
        String deleteStudent = scanner.nextLine();
        for (int i = 0; i < student.length; i++) {
            if (deleteStudent.equals(student[i])) {
                student[i] = null;
            }
        }
    }

    public static void editStudent(String[] student) {
        System.out.println("ten sinh vien ban muon sua");
        String nameStudent = scanner.nextLine();
        System.out.println(" ten ban muon doi thanh ");
        String editStudent = scanner.nextLine();
        for (int i = 0; i < student.length; i++) {
            if (nameStudent.equals(student[i])) {
                student[i] = editStudent;
            }
        }
    }

    public static void addNewStudent(String[] student) {
        System.out.println("them moi sinh vien");
        String newStudent = scanner.nextLine();
        for (int i = 0; i < student.length; i++) {
            if (student[i] == null) {
                student[i] = newStudent;
                break;
            }
        }
    }

}

