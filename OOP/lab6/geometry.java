package OOP.lab6;

import java.sql.SQLInvalidAuthorizationSpecException;

public class geometry {
    public static void main(String[] args) {
        System.out.println("1.Implement and test the following class hierarchy.");
        Square poly1 = new Square(4);
        IsoscelesTrapezoid poly2 = new IsoscelesTrapezoid(15,10,8);
        System.out.printf("Square perimeter: %.2f\n", poly1.perimeter());
        System.out.printf("Square area: %.2f\n", poly1.area());
        System.out.printf("Trapezoid perimeter: %.2f\n", poly2.perimeter());
        System.out.printf("Trapezoid area: %.2f\n", poly2.area());
        System.out.println("-------------------");
        System.out.println("2.Create a collection of objects from the above hierarchy (minimum 5) and display the collection.");
        Polygon[] polygons = {
                new IsoscelesTrapezoid(8,5,7),
                new Square(7),
                new IsoscelesTrapezoid(18,10,9),
                new Square(9),
                new IsoscelesTrapezoid(11,7,5),
                new Square(12),
                new Square(17.5)
        };
        geometryStatic.readTrapezoidCollection(polygons);
    }
}
