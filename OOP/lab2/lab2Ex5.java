package OOP.lab2;

import java.util.Arrays;

public class lab2Ex5 {
    private static int[] search (int c1[], int c2[]){
        int c3[] = new int[Math.min(c1.length, c2.length)];
        int index = 0;
        for (int i=0;i<c1.length;i++)
            for (int j=0;j<c2.length;j++)
                if (c1[i] == c2[j]) {
                    c3[index] = c2[j];
                    index++;
                }
        return Arrays.copyOf(c3, index);
    }
    private static void displayCollection(int[] collection, int index){
        System.out.printf("The collection %d is : ", index);
        for (int i=0; i<collection.length;i++)
           System.out.print(collection[i]+" ");
    }
    public static void main(String[] args) {
        System.out.printf("%s\n","Search and displays all the elements of c2 that are contained in c1.");
        int c1[]={20, 30, -2, 5, 10, 100}; 
        int c2[]={50, 30, -2, 4, 15, 100}; 
        displayCollection(c1, 1);
        System.out.println();
        displayCollection(c2, 2);
        System.out.println();
          
        System.out.println("The elemnts of c2 that are contained in c1, are in c3.");
        int answer[]=search(c1, c2);
        displayCollection(answer, 3);
    }
}
