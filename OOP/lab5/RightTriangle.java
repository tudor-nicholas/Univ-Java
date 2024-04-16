package OOP.lab5;

public class RightTriangle extends Triangle{
    public RightTriangle(double b, double c) {
        super(Math.sqrt(b*b+c*c), b, c);

    }
    @Override
    public String toString(){
        return String.format("Right %s",
                super.toString());
    }
}
