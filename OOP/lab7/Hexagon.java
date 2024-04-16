package OOP.lab7;

public class Hexagon extends Polygon {
    private double sideLength;

    public Hexagon(double sideL) {
        super(6);
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
        return String.format("Hexagon: %s side length: %.2f perimeter: %.2f area: %.2f",super.toString(), sideLength, perimeter(), area());
    }
    @Override
    public double perimeter() {
        return sideLength*6;
    }

    @Override
    public double area() {
        return ((3*Math.sqrt(3))/2)*Math.pow(sideLength, 2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hexagon h1) {
            if (sideLength == h1.getSideLength()) {
                return true;
            }
        }
        return false;
    }

}
