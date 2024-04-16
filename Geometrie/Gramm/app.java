package Geometrie.Gramm;

import java.util.Scanner;

public class app {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Dimension vector(2D,3D):");
        int n = scan.nextInt();
        if(n == 2) {
            Vector2D[] vectorArray = VectorFunctions.assingVectors2D(n);
            Vector2D[] orthogonalArray = VectorFunctions.orthogonalize2D(vectorArray);
            VectorFunctions.showVector2D(orthogonalArray, "Orthogonal");
            double[] normalArray = {orthogonalArray[0].normalize(),
                    orthogonalArray[1].normalize()};
            Vector2D[] gramArray = VectorFunctions.Gram2D(orthogonalArray, normalArray);
            VectorFunctions.showVector2D(gramArray, "Gram-Schmidt");
        } else if(n == 3) {
            Vector3D[] vectorArray = VectorFunctions.assingVectors3D(n);
            Vector3D[] orthogonalArray = VectorFunctions.orthogonalize3D(vectorArray);
            VectorFunctions.showVector3D(orthogonalArray, "Orthogonal");
            double[] normalArray = {orthogonalArray[0].normalize(),
                    orthogonalArray[1].normalize(),
                    orthogonalArray[2].normalize()};
            Vector3D[] gramArray = VectorFunctions.Gram3D(orthogonalArray, normalArray);
            VectorFunctions.showVector3D(gramArray, "Gram-Schmidt");
        } else {
            System.out.println("Error not supported dimension");
        }
    }
}
