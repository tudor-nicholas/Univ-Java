package OOP.lab3;

public class ex2 {
    public static void main(String[] args) {
        //Ex2
        Complexn n1 = new Complexn(3.2, 5.76);
        Complexn n2 = new Complexn(5.2, 32.6);
        System.out.println("Execitiul 2, scaderea a doua numere complexe.");
        Complexn result = Complexf.substarct(n1, n2);
        StaticComplexf.subtract(3.2 , 5.76 , 5.2 , 32.6);
        result.display();
        System.out.println("------------");
        System.out.println("Execitiul 3, inmultirea a doua numere complexe.");
        Complexn multiply = Complexf.multiply(n1, n2);
        StaticComplexf.multiply(3.2 , 5.76 , 5.2 , 32.6);
        multiply.display();
        System.out.println("------------");
        System.out.println("Execitiul 4, modulul unui numar complex.");
        StaticComplexf.modulus(3.2 , 5.76);
        System.out.printf("Modulul primului numar este: %.2f\n", n1.modulus());
        System.out.println("------------");
        Complexn[] numbers = {
                new Complexn(4.5, 6.3),
                new Complexn(44.2, 5.3),
                new Complexn(7.5, 64.9),
                new Complexn(2.6, 6.6),
        };
        Complexn number = Complexf.add(numbers);
        System.out.println("Execitiul 5, adunarea tuturor numerelor complexe.");
        number.display();


    }
}
