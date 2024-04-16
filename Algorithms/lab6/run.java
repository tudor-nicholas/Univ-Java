package Algorithms.lab6;

public class run {
    public static void main(String[] args) {
        String text = "CALCULATE THE SUMMARY OF THIS TEXT";

        //h(x) = x mod 12
        int[] dispersionTable1 = new int[12];
        int collisions1 = StaticFunctions.calculateCollisionsPerLetter(text, dispersionTable1, 12);
        System.out.println("Number of collisions for h(x) = x mod 12: " + collisions1);

        //h(x) = x mod 8
        int[] dispersionTable2 = new int[8];
        int collisions2 = StaticFunctions.calculateCollisionsPerLetter(text, dispersionTable2, 8);
        System.out.println("Number of collisions for h(x) = x mod 8: " + collisions2);

        //h(x) =[M/W (x^2 mod W)], where W = 2^6 and M = 265
        int[] dispersionTable3 = new int[64];
        int collisions3 = StaticFunctions.calculateCollisionsCustomHash1(text, dispersionTable3, 32, 64);
        System.out.println("Number of collisions for h(x) =[M/W (x^2 mod W)]: " + collisions3);

        //h(x) =[M/W (ax mod W)], where W = 2^6 M = 2^5 and a = 101;
        int[] dispersionTable4 = new int[26];
        int collisions4 = StaticFunctions.calculateCollisionsCustomHash2(text, dispersionTable4, 32, 64, 101);
        System.out.println("Number of collisions for h(x) =[M/W (ax mod W)]: " + collisions4);
    }
}
