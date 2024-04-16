package OOP.lab7;

public class Square extends Polygon {
    private double sideLength;

    public Square(double sideL) {
        super(4);
        setSideLength(sideL);
    }
    public void setSideLength(double sl) {
        if ( sl > 0 )
            sideLength = sl;
        else
            throw new IllegalArgumentException("The side length must be > 0" );
    }
    public double getSideLength() {
        return sideLength;
    }
    @Override
    public String toString(){
        return String.format("Square: %s side length: %.2f perimeter: %.2f area: %.2f",super.toString(), sideLength, perimeter(), area());
    }
    @Override
    public double perimeter() {
        return sideLength*4;
    }

    @Override
    public double area() {
        return Math.pow(sideLength, 2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Square s1) {
            if (sideLength == s1.getSideLength()) {
                return true;
            }
        }
        return false;
    }
}
