package Geometrie.Gramm;

import java.util.Scanner;

public class VectorFunctions {
    static Scanner scan = new Scanner(System.in);
    public static Vector2D[] assingVectors2D(int n) {
        Vector2D[] vectorArray = new Vector2D[n];
        for(int i = 0; i < n; i++) {
            int index = i+1;
            System.out.println("Introduceti vectorul " + index);
            System.out.println("x: ");
            double x = scan.nextDouble();
            System.out.println("y: ");
            double y = scan.nextDouble();
            vectorArray[i] = new Vector2D(x, y);
        }
        return vectorArray;
    }
    public static Vector3D[] assingVectors3D(int n) {
        Vector3D[] vectorArray = new Vector3D[n];
        for(int i = 0; i < n; i++) {
            int index = i+1;
            System.out.println("Introduceti vectorul " + index);
            System.out.println("x: ");
            double x = scan.nextDouble();
            System.out.println("y: ");
            double y = scan.nextDouble();
            System.out.println("z: ");
            double z = scan.nextDouble();
            vectorArray[i] = new Vector3D(x, y, z);
        }
        return vectorArray;
    }
    public static Vector2D[] orthogonalize2D(Vector2D[] array) {
        Vector2D[] finalArray = new Vector2D[2];
        finalArray[0] = array[0]; //u1
        // Procedure v2-pr
        Vector2D projection = array[0].projection(array[1]);
        Vector2D u2 = new Vector2D(array[1].getX()-projection.getX(), array[1].getY()-projection.getY());
        finalArray[1] = u2; //u2
        return finalArray;
    }
    public static Vector3D[] orthogonalize3D(Vector3D[] array) {
        Vector3D[] finalArray = new Vector3D[3];
        finalArray[0] = array[0]; //u1
        // Procedure for U2: v2-pr
        Vector3D projection1 = array[0].projection(array[1]);
        Vector3D u2 = new Vector3D(array[1].getX()-projection1.getX(), array[1].getY()-projection1.getY(), array[1].getZ()-projection1.getZ());
        finalArray[1] = u2;
        // Procedure for U3: v3-pr1-pr2
        Vector3D projection2 = u2.projection(array[2]);
        Vector3D projection3 = array[0].projection(array[2]);
        Vector3D u3 = new Vector3D(array[2].getX()-projection2.getX()-projection3.getX(),
                array[2].getY()-projection2.getY()-projection3.getY(),
                array[2].getZ()-projection2.getZ()-projection3.getZ());
        finalArray[2] = u3;
        //final
        return finalArray;
    }
    public static Vector2D[] Gram2D(Vector2D[] oArray, double[] nArray) {
        Vector2D[] finalArray = new Vector2D[2];
        finalArray[0] = new Vector2D(oArray[0].getX()/nArray[0], oArray[0].getY()/nArray[0]);
        finalArray[1] = new Vector2D(oArray[1].getX()/nArray[1], oArray[1].getY()/nArray[1]);
        return finalArray;
    }
    public static Vector3D[] Gram3D(Vector3D[] oArray, double[] nArray) {
        Vector3D[] finalArray = new Vector3D[3];
        finalArray[0] = new Vector3D(oArray[0].getX()/nArray[0], oArray[0].getY()/nArray[0], oArray[0].getZ()/nArray[0]);
        finalArray[1] = new Vector3D(oArray[1].getX()/nArray[1], oArray[1].getY()/nArray[1], oArray[1].getZ()/nArray[1]);
        finalArray[2] = new Vector3D(oArray[2].getX()/nArray[2], oArray[2].getY()/nArray[2], oArray[2].getZ()/nArray[2]);
        return finalArray;
    }
    public static void showVector2D(Vector2D[] array, String name) {
        System.out.printf("%s vector \n", name);
        System.out.printf("v1 = %.3f, %.3f\n", array[0].getX(), array[0].getY());
        System.out.printf("v2 = %.3f, %.3f\n", array[1].getX(), array[1].getY());
    }
    public static void showVector3D(Vector3D[] array, String name) {
        System.out.printf("%s vector \n", name);
        System.out.printf("v1 = %.3f, %.3f, %.3f\n", array[0].getX(), array[0].getY(), array[0].getZ());
        System.out.printf("v2 = %.3f, %.3f, %.3f\n", array[1].getX(), array[1].getY(), array[1].getZ());
        System.out.printf("v3 = %.3f, %.3f, %.3f\n", array[2].getX(), array[2].getY(), array[2].getZ());
    }
}
