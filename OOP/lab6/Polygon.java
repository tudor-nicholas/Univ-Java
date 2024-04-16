package OOP.lab6;

public abstract class Polygon {
    private int sidesNr;
    public Polygon(int sides) {
        sidesNr = sides;
    }
    public void setSidesNr(int sides) {
        if ( sides >= 3 )
            sidesNr = sides;
        else
            throw new IllegalArgumentException("The sides must be >= 3" );
    }
    public int getSidesNr() {
        return sidesNr;
    }

    public String toString(){
        return String.format("Polygon: sides: %d",sidesNr);
    }
    public abstract double perimeter();
    public abstract double area();
}
