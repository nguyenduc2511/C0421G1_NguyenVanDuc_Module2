package module2._20_08_test.bai_lam_them_fix_bug;

import java.util.Scanner;

public class StudentManager {
    public static Student[] studentList = new Student[100];
    public static Scanner scanner = new Scanner(System.in);

    static {
        studentList[0] = new Student(1, "chanh1", 18);
        studentList[1] = new Student(2, "chanh2", 19);
        studentList[2] = new Student(3, "chanh3", 20);

    }

    public static void add() {
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập  tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        int id = 0;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                id = i + 1;
                Student student = new Student(id, name, age);
                studentList[i] = student;
                break;
            }
        }
    }

    public static void display() {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                System.out.println(studentList[i].toString());
            } else {
                break;
            }
        }
    }

    public static void edit() {
        display();
        System.out.println("nhập  id ban muon sua");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i].getId() == id) {
                System.out.println("nhập tên");
                studentList[i].setName(scanner.nextLine());
                System.out.println("nhập  tuổi");
                studentList[i].setAGE(Integer.parseInt(scanner.nextLine()));
                break;
            } else {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("khong tim thay id ban muon sua");
        }
    }

    public static void delete() {
        display();
        System.out.println("nhập  id ban muon xoa");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i].getId() == id) {
                System.out.println("chắc chắn bạn muốn xóa: " + studentList[i].toString());
                System.out.println("1:ok xoa \n" + "2.cancel");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        for (int j = i; j < studentList.length - 1; j++) {
                            studentList[j] = studentList[j + 1];
                            studentList[j + 1] = null;
                        }
                        break;
                    case 2:
                        System.out.println("ban da cancel xoa ");
                        break;
                }
                break;
            } else {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("khong tim thay id ban muon xoa");

        }
    }

    public static void find() {
        System.out.println("tim kiem hoc vien ");
        System.out.println("nhap thong tin ban muon tim kiem theo ten hoac id");
        String find = scanner.nextLine();
        boolean check1 = false;
        boolean check2 = false;
        if(isNumber(find)){
            int id = Integer.parseInt(find);
            for (int i = 0; i < studentList.length; i++) {
                if( studentList[i]!=null) {
                    if (studentList[i].getId() == id ) {
                        System.out.println("thông tin bạn cần tìm: " + studentList[i].toString());
                        check1 = true;
                    } else {
                        break;
                    }
                }else {
                    break;
                }
            }
        }else {
            for (int i = 0; i < studentList.length; i++) {
                if(studentList[i]!=null) {
                    if (studentList[i].getName().contains(find)) {
                        System.out.println("thông tin bạn cần tìm: " + studentList[i].toString());
                        check2 = true;
                    }else {
                        break;
                    }
                }else {
                    break;
                }
            }
        }
        if(check1==false){
            System.out.println("Không tìm thấy thông tin id: "+ find);
        }else if(check2==false){
            System.out.println("Không tìm thấy thông tin name: "+ find);
        }
    }
    public static boolean isNumber(String string){
        try {
            Integer.parseInt(string);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
