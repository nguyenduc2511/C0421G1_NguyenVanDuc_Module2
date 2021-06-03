package test;

public class songuyenTo {
    public static void main(String[] args) {
        int run = 2;
        int number = 0;
        while (true){
            boolean check = true;
            for (int i = 2; i < run; i++) {
                if (run % i == 0) {
                    check=false;
                    break;
                }
            }
            if (check) {
                System.out.println(run);
                number++;
            }
            if (number == 10) {
                break;
            }
            run++;
        }
    }
}

