package Geometrie.Gramm;

import static java.lang.Math.sqrt;

public class Vector3D {
    private double x;

    private double y;

    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    public Vector3D projection(Vector3D v2) {
        // Procedure (a/b)=c ; [c*v1]=pr
        double a = (v2.getX()*x) + (v2.getY()*y) + (v2.getZ()*z);
        double b = (x*x) + (y*y) + (z*z);
        double c = a/b;
        return new Vector3D(c*x, c*y, c*z);
    }
    public double normalize() {
        return sqrt(x*x) + sqrt(y*y)+ sqrt(z*z);
    }
}
