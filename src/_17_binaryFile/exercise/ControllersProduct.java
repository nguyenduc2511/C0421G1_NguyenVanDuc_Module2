package _17_binaryFile.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllersProduct {
    private static List<Product> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void displayControllers() {
        boolean checkLoop = true;
        while (checkLoop) {
            System.out.println("Menu controllers");
            System.out.println("1. Thêm sản phẩm vào file");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Tìm kiếm thông tin sản phẩm dựa trên id");
            System.out.println("4. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayMenu1();
                    break;
                case 2:
                    displayMenu2();
                    break;
                case 3:
                    displayMenu3();
                    break;
                case 4:
                    checkLoop = false;
            }
        }
    }

    private void displayMenu1() {
        System.out.println("Nhập các thông tin cho product");
        System.out.println("1. id sản phẩm");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("2. Tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("3. Sản xuất bởi");
        String madeBy = scanner.nextLine();
        System.out.println("4. Giá sản phẩm");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("5. Các mô tả khác về sản phẩm");
        String describe = scanner.nextLine();
        Product product = new Product(id, name, madeBy, price, describe);
        list.add(product);
    }

    private void displayMenu2() {
        ReadAndWriteProduct.writeObject("src\\_17_binaryFile\\exercise\\product.csv", list);
        List<Product> product;
        product = ReadAndWriteProduct.readObject("src\\_17_binaryFile\\exercise\\product.csv");
        for (Product element: product){
            System.out.println(element.toString());
        }
    }

    private void displayMenu3() {
        System.out.println("Nhập id bạn muốn tìm kiếm product");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = null;
        for (int i =0; i<list.size(); i++){
            if (id == list.get(i).getId()){
                product = list.get(i);
                break;
            }
        }
        System.out.println(product.toString());
    }
}
