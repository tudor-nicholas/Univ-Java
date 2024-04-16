package Algorithms.lab2;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        //HW 1.2
        /* Book book1 = new Book(1, "Ion", "Liviu Rebreanu", "roman");
        Book book2 = new Book(2, "Padurea Spanzuratilor", "Liviu Rebreanu ", "roman");
        Book book3 = new Book(3, "Culmea Spanzuratilor", "Liviu Rebreanu ", "roman");

        System.out.println("Book1 has title " + book1.getTitle());
        book3.setDomain("poezie");
        System.out.println("Book3 has domain " + book3.getDomain());

        System.out.println(book1.toString2()); */
        //HW 1.3
        /* Complex n1 = new Complex(1);
        Complex n2 = new Complex(2);
        n1.display();
        System.out.printf("Addition: %.3f\n", n1.add());
        System.out.printf("Subtract: %.3f\n", n1.subtract());
        System.out.printf("Multiply: %.3f\n", n2.multiply());
        System.out.printf("Modulus: %.3f\n", n2.modulus()); */

        //HW 1.4
        int n = scan.nextInt();
        Complex[] complexArray = new Complex[n];
        for (int i = 0; i < n; i++) {
            complexArray[i] = new Complex(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (complexArray[i].modulus() > complexArray[j].modulus()) {
                    Complex temp = complexArray[j];
                    complexArray[j] = complexArray[i];
                    complexArray[i] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("Number: %.3f\n", complexArray[i].modulus());
        }
    }
}