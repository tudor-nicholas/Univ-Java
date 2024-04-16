package OOP.lab3;

public class StaticComplexf {
    public static void modulus(double a1, double b1) {
        System.out.printf("Modulul celor doua numere este: %.2f\n", Math.sqrt((a1*a1)+(b1*b1)));
    }
    public static void subtract(double a1, double b1, double a2, double b2) {
        double diffReal = a1 - a2;
        double diffImaginary = b1 - b2;
        System.out.printf("Scaderea a doua numere complexe: %.2f  %.2f \n", diffReal, diffImaginary);
    }

    public static void multiply(double a1, double b1, double a2, double b2) {
        double real = (a1 * a2) - (b1 * b2);
        double imaginary = (a1 * b2) + (b1 * a2);
        System.out.printf("Inmultirea a doua numere complexe: %.2f  %.2f \n", real, imaginary);
    }
}
