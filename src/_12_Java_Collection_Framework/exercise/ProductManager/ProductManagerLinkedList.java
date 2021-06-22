package _12_Java_Collection_Framework.exercise.ProductManager;

import java.util.*;

public class ProductManagerLinkedList {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<Product> products = new LinkedList<>();
        addManger(products);
        addManger(products);
        findNameMap(products);
        printManager(products);

    }
    private static void printManager(LinkedList<Product> arr) {
        for (Product arrPrint : arr) {
            System.out.println(arrPrint);
        }
    }
    private static void addManger(LinkedList<Product> arr) {
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
    private static void findNameMap(LinkedList<Product> arr){
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



}
