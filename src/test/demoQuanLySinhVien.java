package test;

import java.util.Scanner;

public class demoQuanLySinhVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] students= new String[50];

        System.out.println("------chuong tirnh quan ly sinh vien------");
        while (true) {

            System.out.println("1. xem danh sach sinh vien");
            System.out.println("2. xoa sinh vien ");
            System.out.println("3. chinh sua thong tin sinh vien ");
            System.out.println("4. them moi sinh vien ");
            System.out.println("5. thoat khoi chuong trinh");
            System.out.println("chon chuc nang su dung: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("code hien thi danh sach sinh vien");
                    for(String student : students){
                        if(student != null){
                            System.out.println(student);
                        }
                    }
                    break;
                case 2:
                    System.out.println("code xoa ten sinh vien");
                    String deleteStudent = scanner.nextLine();

                    for (int i=0; i< students.length;i++){
                        if(deleteStudent.equals(students[i])){
                            students[i]=null;
                        }
                    }
                    break;
                case 3:
                    System.out.println("ten sinh vien ban muon sua");
                    String nameStudent = scanner.nextLine();
                    System.out.println(" ten ban muon doi thanh ");
                    String editStudent= scanner.nextLine();
                    for(int i=0; i< students.length;i++) {
                        if (nameStudent.equals(students[i])) {
                            students[i] = editStudent;
                        }
                    }
                    break;
                case 4:
                    System.out.println("code them moi sinh vien");
                    String newStudent = scanner.nextLine();
                    for(int i=0; i< students.length;i++){
                        if (students[i] == null){
                            students[i]=newStudent;
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("code thoat danh sach sinh vien");
                    System.exit(0);
                default:
                    System.out.println("cho nguoi dung nhap lai ");

            }

        }

    }

    public static void displayListStudent(String[] students) {
        for(String student : students){
            if(student != null){
                System.out.println(student);
            }
    }
}


}

