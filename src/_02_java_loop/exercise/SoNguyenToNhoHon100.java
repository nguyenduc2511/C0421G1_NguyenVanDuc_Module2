package _02_java_loop.exercise;

public class SoNguyenToNhoHon100 {
    public static void main(String[] args) {


//        Cach 1:
//        int run = 2;
//        while (true){
//            boolean check = true;
//            for (int i = 2; i < run; i++) {
//                if (run % i == 0) {
//                    check=false;
//                    break;
//                }
//            }
//            if (check) {
//                System.out.println(run);
//            }
//            if (run>= 100) {
//                break;
//            }
//            run++;
//        }

        boolean check = true;
        for(int run = 2;run<100;run++){
            for (int i = 2; i < run; i++) {
                if (run % i == 0) {
                    check=false;
                    break;
                }else {
                    check=true;
                }
        }
            if (check) {
                System.out.println(run);
            }
    }
}
}
