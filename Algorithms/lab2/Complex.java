package Algorithms.lab2;

import java.util.Scanner;

public class Complex {
    private final int nid;
    private final double a;
    private final double b;
    static Scanner scan = new Scanner(System.in);

    public Complex(int i) {
        System.out.printf("Complex Number %d: \n", i+1);
        System.out.println("a: ");
        double a = scan.nextDouble();
        System.out.println("b: ");
        double b = scan.nextDouble();
        this.a = a;
        this.b = b;
        this.nid = i;
    }

    public void display() {
        System.out.printf("Complex Number: %.3f %.3f\n", a, b);
    }

    public double add() {
        return a + b;
    }
    
    public double subtract() {
        return a - b;
    }
    
    public double multiply() {
        return a * b;
    }

    public double modulus() {
        if ((int)b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a % b;
    }
}
