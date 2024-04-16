package OOP.lab3;

public class Complexn {
    private double a;
    private double b;

    public Complexn(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void display() {
        System.out.printf("Numarul complex este format din %.2f  %.2f\n", a, b);
    }

    public double modulus() {
        return Math.sqrt(a * a + b * b);
    }

    public void add(double a, double b) {
        this.a += a;
        this.b += b;
    }
}
