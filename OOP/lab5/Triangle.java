package OOP.lab5;

public class Triangle {
    private double a;
    private double b;
    private double c;
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public void setA(double a) {
        if ( a >= 1)
            this.a = a;
        else
            throw new IllegalArgumentException("The line must be >= 1" );
    }
    public void setB(double b) {
        if ( b >= 1)
            this.b = b;
        else
            throw new IllegalArgumentException("The line must be >= 1" );
    }
    public void setC(double c) {
        if ( c >= 1)
            this.c = c;
        else
            throw new IllegalArgumentException("The line must be >= 1" );
    }
    public double perimeter() {
        return a + b + c;
    }
    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt( s * (s - a) * (s - b) * (s- c) );
    }
    public String toString(){
        return String.format("Triangle a: %.2f b: %.2f c: %.2f perimeter: %.2f area: %.2f ", a, b, c, perimeter(), area());
    }
}
