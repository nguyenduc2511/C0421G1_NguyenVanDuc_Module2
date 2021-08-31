package reviewBaiTapATrung;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteStudent {

    public List<String[]> readFile(String filePath) {
        List<String[]> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] element = line.split(",");
                list.add(element);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeData(String filePath, String line) {
        try {
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clearData(String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeData(String filePath, String lineRemove) {
        List<String[]> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals(lineRemove)) {
                    String[] element = line.split(",");
                    list.add(element);
                }
            }
            new ReadAndWriteStudent().clearData(filePath);
            String line2="";
            for (String[] element : list) {
                line2 = Integer.parseInt(element[0])+ ","+ element[1]+ ","+ Integer.parseInt(element[2])+","+element[3];
                new ReadAndWriteStudent().writeData(filePath,line2);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editData(String filePath, String lineLocation, String lineEdit){
        List<String[]> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            String line ="";
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals(lineLocation)) {
                    String[] element = line.split(",");
                    list.add(element);
                }else {
                    String[] element = lineEdit.split(",");
                    list.add(element);
                }
            }
            new ReadAndWriteStudent().clearData(filePath);
            String line2="";
            for (String[] element : list) {
                line2 = Integer.parseInt(element[0])+ ","+ element[1]+ ","+ Integer.parseInt(element[2])+","+element[3];
                new ReadAndWriteStudent().writeData(filePath,line2);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

