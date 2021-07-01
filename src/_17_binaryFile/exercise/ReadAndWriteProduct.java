package _17_binaryFile.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteProduct {
    public static void writeObject(String path,List<Product>  product) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(product);
        }catch (IOException exception){
            exception.printStackTrace();
        }finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static List<Product>  readObject(String path){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectOutputStream = null;
        List<Product> list = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(path);
            objectOutputStream = new ObjectInputStream(fileInputStream);
            list = (List<Product>) objectOutputStream.readObject();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return list;
    }
}
