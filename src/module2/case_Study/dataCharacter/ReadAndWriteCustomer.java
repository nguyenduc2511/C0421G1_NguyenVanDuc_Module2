package module2.case_Study.dataCharacter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCustomer {

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
            FileWriter fileWriter = new FileWriter(filePath, true);
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
            new ReadAndWriteCustomer().clearData(filePath);
            String line2 = "";
            for (String[] element : list) {
                for(int i = 0; i<element.length;i++){
                    if(i==0){
                        line2+= Integer.parseInt(element[i]);
                    }else {
                        line2 += element[i];
                    }
                    if(i != element.length-1){
                        line2 += ",";
                    }
                }
//                line2 = Integer.parseInt(element[0])+","+ element[1]+","+ element[2]+","+ element[3]+","+ element[4]+","+element[5]+","+ element[6]+","+ element[7]+","+ element[8];
                new ReadAndWriteCustomer().writeData(filePath, line2);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editData(String filePath, String lineLocation, String lineEdit) {
        List<String[]> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals(lineLocation)) {
                    String[] element = line.split(",");
                    list.add(element);
                } else {
                    String[] element = lineEdit.split(",");
                    list.add(element);
                }
            }
            new ReadAndWriteCustomer().clearData(filePath);
            String line2 = "";
            for (String[] element : list) {
                for(int i = 0; i<element.length;i++){
                    if(i==0){
                        line2+= Integer.parseInt(element[i]);
                    }else {
                        line2 += element[i];
                    }
                    if(i != element.length-1){
                        line2 += ",";
                    }

                }
//                line2 = Integer.parseInt(element[0])+","+ element[1]+","+ element[2]+","+ element[3]+","+ element[4]+","+element[5]+","+ element[6]+","+ element[7]+","+ element[8];
                new ReadAndWriteCustomer().writeData(filePath, line2);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

