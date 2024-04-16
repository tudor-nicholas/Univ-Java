package lab1;

import java.util.Scanner;
import java.util.Vector;

public class ex5 {
    public static Scanner scan = new Scanner(System.in);

    public static int[] readLine() {
        int[] v = new int[4];
        System.out.println("Enter the line numbers:");
        System.out.println("a:");
        v[0] = scan.nextInt();
        System.out.println("b:");
        v[1] = scan.nextInt();
        System.out.println("c:");
        v[2] = scan.nextInt();
        System.out.println("d:");
        v[3] = scan.nextInt();
        return v;
    }

    public static Vector<Integer> readPoints() {
        Vector<Integer> p = new Vector<>();
        System.out.println("Enter points:");
        System.out.println("x:");
        p.add(scan.nextInt());
        System.out.println("y:");
        p.add(scan.nextInt());
        System.out.println("z:");
        p.add(scan.nextInt());
        return p;
    }

    public static void checkPoints(int[] v, Vector<Vector<Integer>> points) {
        for (int i = 0; i < points.size(); i++) {
            Vector<Integer> p = points.get(i);
            if ((v[0] * p.get(0)) + (v[1] * p.get(1)) + (v[2] * p.get(2)) + v[3] == 0) {
                System.out.println("Point is on the plane");
            } else {
                System.out.println("Point is not on the plane");
            }
        }
    }

    public static void removePoints(int oct, Vector<Vector<Integer>> points) {
        for (int i = 0; i < points.size(); i++) {
            Vector<Integer> p = points.get(i);
            switch (oct) {
                case 1:
                    if (p.get(0) > 0 && p.get(1) > 0 && p.get(2) > 0) {
                        System.out.println("Point");
                        System.out.print(p);
                        System.out.println(" is in octant 1.");
                    } else {
                        points.remove(i);
                    }
                    break;
                case 2:
                    if (p.get(0) < 0 && p.get(1) > 0 && p.get(2) > 0) {
                        System.out.println("Point");
                        System.out.print(p);
                        System.out.println(" is in octant 1.");
                    } else {
                        points.remove(i);
                    }
                    break;
                case 3:
                    if (p.get(0) < 0 && p.get(1) < 0 && p.get(2) > 0) {
                        System.out.println("Point");
                        System.out.print(p);
                        System.out.println(" is in octant 1.");
                    } else {
                        points.remove(i);
                    }
                    break;
                case 4:
                    if (p.get(0) > 0 && p.get(1) < 0 && p.get(2) > 0) {
                        System.out.println("Point");
                        System.out.print(p);
                        System.out.println(" is in octant 1.");
                    } else {
                        points.remove(i);
                    }
                    break;
                case 5:
                    if (p.get(0) > 0 && p.get(1) > 0 && p.get(2) < 0) {
                        System.out.println("Point");
                        System.out.print(p);
                        System.out.println(" is in octant 1.");
                    } else {
                        points.remove(i);
                    }
                    break;
                case 6:
                    if (p.get(0) < 0 && p.get(1) > 0 && p.get(2) < 0) {
                        System.out.println("Point");
                        System.out.print(p);
                        System.out.println(" is in octant 1.");
                    } else {
                        points.remove(i);
                    }
                    break;
                case 7:
                    if (p.get(0) < 0 && p.get(1) < 0 && p.get(2) < 0) {
                        System.out.println("Point");
                        System.out.print(p);
                        System.out.println(" is in octant 1.");
                    } else {
                        points.remove(i);
                    }
                    break;
                case 8:
                    if (p.get(0) > 0 && p.get(1) < 0 && p.get(2) < 0) {
                        System.out.println("Point");
                        System.out.print(p);
                        System.out.println(" is in octant 1.");
                    } else {
                        points.remove(i);
                    }
                    break;
                default:
                    System.out.println("Invalid quadrant.");
                    break;
            }
        }
    }

    public static void translatePoints(Vector<Vector<Integer>> points) {
        for (int i = 0; i < points.size(); i++) {
            Vector<Integer> p = points.get(i);
            int x = p.get(0) + 2;
            int y = p.get(1) - 3;
            int z = p.get(2) + 1;
            p.set(0, x);
            p.set(1, y);
            p.set(2, z);
        }
    }

    public static int colinearCheck(Vector<Vector<Integer>> points) {
        Vector<Integer> p1 = points.get(0);
        Vector<Integer> p2 = points.get(1);
        Vector<Integer> p3 = points.get(2);
        int[] v1 = { p2.get(0) - p1.get(0), p2.get(1) - p1.get(1), p2.get(2) - p1.get(2) };
        int[] v2 = { p3.get(0) - p1.get(0), p3.get(1) - p1.get(1), p3.get(2) - p1.get(2) };
        // Calculate the cross product of v1 and v2
        int[] crossProduct = {
                v1[1] * v2[2] - v1[2] * v2[1], // i component
                v1[2] * v2[0] - v1[0] * v2[2], // j component
                v1[0] * v2[1] - v1[1] * v2[0] // k component
        };
        // Calculate the magnitude of the cross product
        int magnitude = Math.abs(crossProduct[0]) + Math.abs(crossProduct[1]) + Math.abs(crossProduct[2]);

        return magnitude;
    }

    public static void main(String[] args) {
        /* int oct = 1; */
        Vector<Vector<Integer>> points = new Vector<>();
        System.out.println("Enter the number of points");
        int n = scan.nextInt();
        int[] v = readLine();
        for (int i = 0; i < n; i++) {
            Vector<Integer> p = readPoints();
            points.add(p);
        }
        checkPoints(v, points);
        System.out.printf("Result colinear: %d\n", colinearCheck(points));
        /* removePoints(oct, points);
        for (int i = 0; i < points.size(); i++) {
            System.out.print(points.get(i));
        } */
        translatePoints(points);
        for (int i = 0; i < points.size(); i++) {
            System.out.print(points.get(i));
        }
    }
}
