package OOP.lab3;

public class Complexf {
    public static Complexn substarct(Complexn n1, Complexn n2) {
        Complexn number = new Complexn(n1.getA() - n2.getA(), n1.getB() - n2.getB());
        return number;
    }

    public static Complexn multiply(Complexn n1, Complexn n2) {
        double real = (n1.getA() * n2.getA()) - (n1.getB() * n2.getB());
        double imaginary = (n1.getA() * n2.getB()) + (n1.getB() * n2.getA());
        return new Complexn(real, imaginary);
    }

    public static Complexn add(Complexn[] numbers) {
        Complexn result = new Complexn(0, 0);
        for (int i = 0; i < numbers.length; i++) {
            result.add(numbers[i].getA(), numbers[i].getB());
        }
        return result;
    }
}
