package OOP.lab2;

public class lab2Ex2 {
    public static void main(String[] args) {
        float[] coef={1,2,3,4};
        float arg=2;
        System.out.println("P04 - Poynomial value");
        polinom.displayPol(coef);
        System.out.printf("\nThe polinomial value for x=%.0f is %.0f\n",arg,polinom.polynomialValue(coef,arg));
    } 
}
