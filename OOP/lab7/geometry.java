package OOP.lab7;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class geometry {
    public static void main(String[] args) throws FileNotFoundException {
        //Ex1
        System.out.println("1.Create a collection of 6 polygons: 4 squares and 2 isosceles trapezoids.");
        System.out.println();
        Polygon[] polygons1 = {
                new Square(4),
                new Square(6),
                new Square(5),
                new Square(8),
                new IsoscelesTrapezoid(12, 7, 6),
                new IsoscelesTrapezoid(15,9,7)
        };
        //Before
        for (Polygon p : polygons1) {
            System.out.println(p);
        }
        //After
        for (Polygon p : polygons1) {
            if (p instanceof Square pTest) {
                pTest.setSideLength(2*pTest.getSideLength());
            }
        }
        for (Polygon p : polygons1) {
            System.out.println(p);
        }
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println();
        //Ex2
        System.out.println("2.Extend the polygon hierarchy with the type regular hexagon. Create a collection of 3 polygons, containing one polygon for each type. Display the collection.");
        System.out.println();
        Polygon[] polygons2 = {
                new Square(6),
                new IsoscelesTrapezoid(14,8,4),
                new Hexagon(8)
        };
        for (Polygon p : polygons2) {
            System.out.println(p);
        }
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println();
        //Ex3
        System.out.println("3.Load a polygon collection from a text file. The file contains the following data:");
        System.out.println();
        Polygon[] polygons3 = new Polygon[4];
        int n=0;
        Scanner input = new Scanner(new File("D:\\Vs Code\\JavaJet\\src\\OOP\\lab7\\polygons.txt"));
        while(input.hasNext()) {
            String line = input.nextLine();
            String[] type = line.split(" ");
            switch (type[0]) {
                case "square":
                    double squareSide = Double.parseDouble(type[1]);
                    polygons3[n] = new Square(squareSide);
                    n++;
                    break;
                case "trapezoid":
                    double largeBase = Double.parseDouble(type[1]);
                    double smallBase = Double.parseDouble(type[2]);
                    double side = Double.parseDouble(type[3]);
                    polygons3[n] = new IsoscelesTrapezoid(largeBase, smallBase, side);
                    n++;
                    break;
                case "hexagon":
                    double sideh = Double.parseDouble(type[1]);
                    polygons3[n] = new Hexagon(sideh);
                    n++;
                    break;
            }
        }
        for (Polygon p : polygons3) {
            System.out.println(p);
        }
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println();
        //Ex4
        System.out.println("4.Define the equals method for polygons. Two polygons are equals if they have the same type and the same values for sides.");
        System.out.println();
        Square sq1 = new Square(4);
        Square sq2 = new Square(4);
        if (sq1.equals(sq2)) {
            System.out.println("square1 = square2");
        } else {
            System.out.println("square1 != square2");
        }
        Hexagon h1 = new Hexagon(6);
        Hexagon h2 = new Hexagon(8);
        if (h1.equals(h2)) {
            System.out.println("hexagon1 = hexagon2");
        } else {
            System.out.println("hexagon1 != hexagon2");
        }
        IsoscelesTrapezoid t1 = new IsoscelesTrapezoid(10, 6, 5);
        IsoscelesTrapezoid t2 = new IsoscelesTrapezoid(10, 6, 5);
        if (t1.equals(t2)) {
            System.out.println("trapezoid1 = trapezoid2");
        } else {
            System.out.println("trapezoid1 != trapezoid2");
        }
    }
}
