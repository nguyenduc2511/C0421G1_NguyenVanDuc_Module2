package exam_module2.dataStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteByteStreamExam<T> implements InterFaceByteStreamexam<T> {
    @Override
    public List<T> readFileByteStream(String path) {
        List<T> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (List<T>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(" Giữ liệu trống ");
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

}
