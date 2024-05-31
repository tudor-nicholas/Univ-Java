package OOP.lab13;
import java.util.ArrayList;

class Complex {
    private double realPart;
    private double imaginaryPart;

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        return "( " + realPart + " , " + imaginaryPart + " )";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Complex complexNumber = (Complex) obj;
        return Double.compare(complexNumber.realPart, realPart) == 0 && Double.compare(complexNumber.imaginaryPart, imaginaryPart) == 0;
    }
}

public class ComplexNumbers {
    public static void display(ArrayList<Complex> complexList, String title) {
        System.out.print(title);
        for (Complex complexNumber : complexList)
            System.out.printf(" %s", complexNumber);
        System.out.println();
    }

    public static boolean contains(ArrayList<Complex> complexList, Complex rNumber) {
        for(Complex complexnumber : complexList) {
            if (complexnumber.equals(rNumber)) {
                return true;
            }
        }
        return false;
    }
    public static int indexOf(ArrayList<Complex> complexList, Complex rNumber) {
        for (int i = 0; i < complexList.size(); i++) {
            if (complexList.get(i).equals(rNumber)) {
                return i;
            }
        }
        return -1;
    }
    public static ArrayList<Complex> remove(ArrayList<Complex> complexList, Complex rNumber) {
        for(Complex complexnumber : complexList) {
            if (complexnumber.equals(rNumber)) {
                complexList.remove(complexnumber);
            }
        }
        return complexList;
    }

    public static void main(String[] args) {
        ArrayList<Complex> list = new ArrayList<Complex>();
        list.add(new Complex(-1,2));
        list.add(new Complex(-2,4));
        list.add(new Complex(3,-5));
        list.add(new Complex(10,-1));
        list.add(new Complex(100,200));
        Complex z1 = new Complex(10, -1);
        Complex z2 = new Complex(-2, -4);
        display(list, "The initial collection:");
        System.out.printf("z1 = %s%n", z1);
        System.out.printf("z2 = %s%n", z2);
        if(list.contains(z1)) {
            System.out.println("Z1 is in the collection");
        } else {
            System.out.println("Z1 is not in the collection");
        }
        if(list.contains(z2)) {
            System.out.println("Z2 is in the collection");
        } else {
            System.out.println("Z2 is not in the collection");
        }
        System.out.printf("The index of %s is %d%n", z1, list.indexOf(z1));
        list.remove(z1);
        System.out.printf("After removing %s", z1);
        display(list, "The collection is:");
    }
}

