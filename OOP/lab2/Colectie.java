package OOP.lab2;

public class Colectie {
    public static int search (int c[], int x){
        boolean found=false;
        int i;
        for (i=0;i<c.length;i++)
           if (c[i]==x){found=true;break;} 
        if (found) return i+1;
        else return -1;
    }
    public void displayCollection(int[] collection){
        System.out.print("The collection is : ");
        for (int i=0; i<collection.length;i++)
           System.out.print(collection[i]+" ");
    }
}
