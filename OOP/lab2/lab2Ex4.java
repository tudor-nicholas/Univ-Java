package OOP.lab2;

public class lab2Ex4 {
    public static void main(String[] args) {
        Colectie colectie = new Colectie();
        //Search for a int value in a collection
        System.out.printf("%s\n","Search for a value in a int collection");
        int collection[]={20, 30, -2, 5, 10, 100}; 
        colectie.displayCollection(collection);
        System.out.println();

        int val=10;
        int answer=Colectie.search(collection,val);
        
        if(answer!=-1) System.out.printf("%d is in the collection at position %d\n",val,answer);
        else System.out.printf("%d is not in the colection\n",val);
        
        val=110;
        answer=Colectie.search(collection,val);
        if(answer!=-1) System.out.printf("%d is in the collection at position %d\n",val,answer);
        else System.out.printf("%d is not in the colection\n",val);
    }
}
