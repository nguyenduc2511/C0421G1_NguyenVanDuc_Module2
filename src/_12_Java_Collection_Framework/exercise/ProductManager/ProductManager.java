package _12_Java_Collection_Framework.exercise.ProductManager;

import java.util.*;

public class ProductManager {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        addManger(products);
        addManger(products);
        addManger(products);
        addManger(products);
//        priceHight(products);
        hightPrice(products);
        findName(products);
        findNameMap(products);
        edditNameById(products);
        removeManger(products);
        printManager(products);
    }

    private static void printManager(ArrayList<Product> arr) {
        for (Product arrPrint : arr) {
            System.out.println(arrPrint);
        }
    }

    private static void edditNameById(ArrayList<Product> arr) {
        System.out.println("nhap id ban tim de sua ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getId() == id) {
                System.out.println("nhap name muon sua");
                String name = scanner.nextLine();
                System.out.println("nhap price ban muon sua ");
                double price = Double.parseDouble(scanner.nextLine());
                arr.get(i).setName(name);
                arr.get(i).setPrice(price);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("khong tim thay id");
        }
    }

    private static void removeManger(ArrayList<Product> arr) {
        System.out.println("nhap id ban muon xoa ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getId() == id) {
                arr.remove(i);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("khong tim thay id " + id);
        }
    }

    private static void findNameMap(ArrayList<Product> arr){
        Map<String,Product> map = new HashMap<>();
        for (int i = 0; i<arr.size(); i++) {
            map.put(arr.get(i).getName(), arr.get(i));
        }
        System.out.println("nhap name muon tim");
        String name = scanner.nextLine();
        if(map.containsKey(name)){
            System.out.println(map.get(name));
        }else {
            System.out.println("khong tim thay ten " + name);
        }

    }

    private static void findName(ArrayList<Product> arr) {
        System.out.println("nhap name muon tim");
        String name = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().equals(name)) {
                System.out.println(arr.get(i));
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("khong tim thay ten " + name);
        }
    }

    private static void addManger(ArrayList<Product> arr) {
        Product product = new Product();
        System.out.println("nhap du lieu ");
        System.out.println("nhap id ");
        int id = Integer.parseInt(scanner.nextLine());
        product.setId(id);
        System.out.println("nhap name ");
        String name = scanner.nextLine();
        product.setName(name);
        System.out.println("nhap price ");
        double price = Double.parseDouble(scanner.nextLine());
        product.setPrice(price);
        arr.add(product);
    }
private static void hightPrice(ArrayList<Product> arr){
    Map<Double,Product> map = new TreeMap<>();
    for (int i = 0; i<arr.size(); i++) {
        map.put(arr.get(i).getPrice(), arr.get(i));
    }
    for (Map.Entry<Double, Product> key : map.entrySet()) {
        System.out.println(key);
    }

}
    private static void priceHight(ArrayList<Product> arr) {
//        sắp xếp tăng dần theo price
        PriceComparatorHight priceComparator = new PriceComparatorHight();
        arr.sort(priceComparator);
        for (Product element : arr) {
            System.out.println(element);
        }
    }

    private static void priceLow(ArrayList<Product> arr) {
//        sắp xếp giam dần theo price
        PriceComparatorLow priceComparator2 = new PriceComparatorLow();
        arr.sort(priceComparator2);
        for (Product element : arr) {
            System.out.println(element);
        }
    }
}
