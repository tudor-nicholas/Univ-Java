package Algorithms.lab6;

public class StaticFunctions {
    public static int calculateCollisionsPerLetter(String text, int[] dispersionTable, int modulo) {
        int collisions = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                int index = ch % modulo;
                if (dispersionTable[index] >= 1) {
                    collisions++;
                }
                dispersionTable[index]++;
            }
        }
        return collisions;
    }
    public static int calculateCollisionsCustomHash1(String text, int[] dispersionTable, int M, int W) {
        int collisions = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                // Calculate the hash code using the custom hash function
                int hashCode = (W / M) * ((int) Math.pow(ch, 2) % W);
                int index = hashCode % dispersionTable.length;
                if (dispersionTable[index] != 0) {
                    collisions++;
                }
                dispersionTable[index]++;
            }
        }
        return collisions;
    }
    public static int calculateCollisionsCustomHash2(String text, int[] dispersionTable, int M, int W, int a) {
        int collisions = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                // Calculate the hash code using the custom hash function
                int hashCode = (W / M) * ((ch * a) % W);
                int index = hashCode % dispersionTable.length;
                if (dispersionTable[index] != 0) {
                    collisions++;
                }
                dispersionTable[index]++;
            }
        }
        return collisions;
    }
}
