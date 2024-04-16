package OOP.lab2;

public class lab2Ex3 {
    private static int search (int c[], int x){
        boolean found=false;
        int i;
        for (i=0;i<c.length;i++)
           if (c[i]==x){found=true;break;} 
        if (found) return i+1;
        else return -1;
    }
    private static void displayCollection(int[] collection){
        System.out.print("The collection is : ");
        for (int i=0; i<collection.length;i++)
           System.out.print(collection[i]+" ");
    }
    public static void main(String[] args) {
        //Search for a int value in a collection
        System.out.printf("%s\n","Search for a value in a int collection");
        int collection[]={20, 30, -2, 5, 10, 100}; 
        displayCollection(collection);
        System.out.println();

        int val=10;
        int answer=search(collection,val);
        
        if(answer!=-1) System.out.printf("%d is in the collection at position %d\n",val,answer);
        else System.out.printf("%d is not in the colection\n",val);
        
        val=110;
        answer=search(collection,val);
        if(answer!=-1) System.out.printf("%d is in the collection at position %d\n",val,answer);
        else System.out.printf("%d is not in the colection\n",val);
    }  

}
