package _16_IO_File.practise;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    private static final String FILE_PATH = "src\\_16_IO_File\\data\\number.csv";

    public void readFileText(String filePath) {
        try {
            // Đọc file theo đường dẫn
            File file = new File(filePath);
            // Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ.
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            // Đọc từng dòng của file và tiến hành cộng tổng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            // Hiển thị ra màn hình tổng các số nguyên trong file
            System.out.println("Tổng = " + sum);
        } catch (Exception e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }
        public static void main(String[] args) {
            System.out.println("Nhập đường dẫn file: ");
//            D:\code\C0421G1_NguyenVanDuc_Module2\src\_16_IO_File\data\number.csv
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();

            ReadFileExample readfileEx = new ReadFileExample();
            readfileEx.readFileText(FILE_PATH);
        }
}

