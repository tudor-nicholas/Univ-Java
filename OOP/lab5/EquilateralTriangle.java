package OOP.lab5;

public class EquilateralTriangle extends Triangle{
    public EquilateralTriangle(double a) {
        super(a, a, a);
    }
    @Override
    public String toString(){
        return String.format("Equilateral %s",
                super.toString());
    }
}
