package _03_Java_array.practise;

import java.util.Scanner;

public class TImGiaTriTrongMang {
    public static void main(String[] args) {
        String[] students = {"Hung", "Dung", "Duc", "Nhat", "Tai", "Phuc", "Ha", "Quang", "Huy", "Thang"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name’s student:");
        String name = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(name)) {
                System.out.println("Position of the students in the list " + name + " is: " + (i + 1));
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Not found" + name + " in the list.");
        }
    }
}
