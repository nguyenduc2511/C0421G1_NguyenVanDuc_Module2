package _10_DSA_List.exercise;

public class TestArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> testArr = new MyArrayList<>();

        testArr.add(10);
        testArr.add(50);
        testArr.add(60);
        testArr.add(1,5);
        testArr.add(1,6);
        testArr.add(9,99);
        testArr.forEach();
        System.out.println("\n");
        testArr.remove(9);
        testArr.forEach();


    }
}
