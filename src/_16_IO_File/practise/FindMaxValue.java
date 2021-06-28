package _16_IO_File.practise;

import java.util.List;

public class FindMaxValue {
    private static final String FILE_PATH = "src\\_16_IO_File\\data\\number.csv";
    private static final String FILE_PATH2 = "src\\_16_IO_File\\data\\result.csv";

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile(FILE_PATH);
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile(FILE_PATH2, maxValue);
        readAndWriteFile.printFile(FILE_PATH);
        readAndWriteFile.printFile(FILE_PATH2);

    }
}
