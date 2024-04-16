package OOP.lab2;

public class lab2Ex6 {
    public static void main(String[] args) {
        short x=100, y=1;
        for (int i=0; i<=15;i++){
            System.out.printf("b%d\t => ", i);
            if((x & y) != 0)System.out.println("\t1");
            else System.out.println("\t0");
            y<<=1;
        }
    }
}
