package Geometrie.Gramm;

import static java.lang.Math.sqrt;

public class Vector2D {
    private double x;

    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public Vector2D projection(Vector2D v2) {
        // Procedure (a/b)=c    [c*v1]=pr
        double a = (v2.getX()*x) + (v2.getY()*y);
        double b = (x*x) + (y*y);
        double c = a/b;
        return new Vector2D(c*x, c*y);
    }
    public double normalize() {
        return sqrt(x*x) + sqrt(y*y);
    }

}
