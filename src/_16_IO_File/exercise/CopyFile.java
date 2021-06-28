package _16_IO_File.exercise;

import java.io.*;
public class CopyFile {
    public void copyfile(String file_path_location, String file_path) {
        try {
            File file = new File(file_path_location);
            File file1 = new File(file_path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            if (!file1.exists()) {
                file1.createNewFile();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                    writeFile(file_path,line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String filepath, String line) {
        try {
            FileWriter fileWriter = new FileWriter(filepath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(line);
           bufferedWriter.append(line);
//           bufferedWriter.append("\n");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public void printFile(String File_path){
        try {
            File file = new File(File_path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }
}
