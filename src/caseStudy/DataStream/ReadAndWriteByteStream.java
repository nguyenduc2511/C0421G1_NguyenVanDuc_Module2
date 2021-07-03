package caseStudy.DataStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteByteStream<T> implements InterFaceByteStream<T>{
    @Override
    public List<T> readFileByteStream(String path) {
        List<T> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
           ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            T dm = null;
            while((dm = (T) objectInputStream.readObject()) != null){
                list.add(dm);
            }
            objectInputStream.close();
            fileInputStream.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(" data null");
        }
        return list;
    }

    @Override
    public void writeFileByteStream(List<T> list, String path) {
        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void clearData(String path) {
        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(null);
            objectOutputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
