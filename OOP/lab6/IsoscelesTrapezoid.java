package OOP.lab6;

public class IsoscelesTrapezoid extends Polygon {
    private double largeBase;
    private double smallBase;
    private double side;
    public IsoscelesTrapezoid(double largeB, double smallB, double sideB) {
        super(4);
        setLargeBase(largeB);
        setSmallBase(smallB);
        setSides(sideB);
    }
    public void setLargeBase(double lB) {
        if ( lB > 0 )
            largeBase = lB;
        else
            throw new IllegalArgumentException("The large base must be > 0 ");
    }
    public void setSmallBase(double sB) {
        if ( sB > 0 )
            smallBase = sB;
        else
            throw new IllegalArgumentException("The small base must be > 0 ");
    }
    public void setSides(double sideB) {
        if ( sideB > 0 )
            side= sideB;
        else
            throw new IllegalArgumentException("The side must be > 0 ");
    }
    public double getLargeBase() {
        return largeBase;
    }
    public double getSmallBase() {
        return smallBase;
    }

    public double getSide() {
        return side;
    }
    @Override
    public String toString(){
        return String.format("IsoscelesTrapezoid: %s side length: %.2f large base: %.2f small base: %.2f perimeter: %.2f area: %.2f",super.toString(), side, largeBase, smallBase, perimeter(), area());
    }
    @Override
    public double perimeter() {
        return largeBase + smallBase + (side*2);
    }

    @Override
    public double area() {
        double h = Math.sqrt(side-((largeBase-smallBase)/2));
        return ((largeBase+smallBase)/2)*h;
    }
}
