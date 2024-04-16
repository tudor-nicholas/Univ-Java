package OOP.lab2;

public class lab2Ex1 {

    public static double polynomialValue(float[] c, float argValue){
        int degree=c.length-1;
        float polVal=0;
        for (int i=0; i<=degree;i++)
            polVal += c[i]*Math.pow(argValue, degree-i);
        return polVal;
    }
    
    public static void displayPol(float[] c){
        int d=c.length-1;
       
        System.out.print("The polinomial is ");
        for (int i=0; i<=d;i++){
            System.out.printf("%.0fx^%d",c[i],d-i);
            if (i < d) System.out.print("+");
        }
    }

    public static void main(String[] args) {
        float[] coef={1,2,3,4};
        float arg=2;
        System.out.println("P04 - Poynomial value");
        displayPol(coef);
        System.out.printf("\nThe polinomial value for x=%.0f is %.0f\n",arg,polynomialValue(coef,arg));
    }  
}
