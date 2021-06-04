package test;

public class TamGiacCanDeMo {
    public static void main(String[] args) {

        for(int i=0;i<5;i++){
            for(int n =0;n<5;n++){
                if(n<4-i){
                    System.out.print(" ");
                    continue;
                }
                System.out.print("*");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}

