package lab1;
import java.util.Scanner;
import java.util.Vector;

public class ex1 {
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

    public static int checkPoint(int[] v, Vector<Integer> p) {
        if ((v[0] * p.get(0)) + (v[1] * p.get(1)) + (v[2] * p.get(2)) + v[3] == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void removePoints(int q, Vector<Vector<Integer>> points) {
        for (int i = 0; i < points.size(); i++) {
            Vector<Integer> point = points.get(i);
            switch (q) {
                case 1:
                    if (point.get(0) > 0 && point.get(1) > 0) {
                        System.out.println("Point");
                        System.out.print(point);
                        System.out.println(" is in quadrant 1.");
                    } else {
                        points.remove(i);
                    }
                    break;
                case 2:
                    if (point.get(0) < 0 && point.get(1) > 0) {
                        System.out.println("Point");
                        System.out.print(point);
                        System.out.println(" is in quadrant 2.");
                    } else {
                        points.remove(i);
                    }
                    break;
                case 3:
                    if (point.get(0) < 0 && point.get(1) < 0) {
                        System.out.println("Point");
                        System.out.print(point);
                        System.out.println(" is in quadrant 3.");
                    } else {
                        points.remove(i);
                    }
                    break;
                case 4:
                    if (point.get(0) > 0 && point.get(1) < 0) {
                        System.out.println("Point");
                        System.out.print(point);
                        System.out.println(" is in quadrant 1.");
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
            Vector<Integer> point = points.get(i);
            int x = point.get(0) + 2;
            int y = point.get(1) - 3;
            point.set(0, x);
            point.set(1, y);
        }
    }

    public static int colinearCheck(Vector<Integer> p1, Vector<Integer> p2, Vector<Integer> p3) {
        int derivat = ((p2.get(0)*p3.get(1))-(p3.get(0)*p2.get(1))
                        - (p1.get(0)*p3.get(1))-(p3.get(0)*p1.get(1))
                        + (p1.get(0)*p2.get(1))-(p2.get(0)*p1.get(1)));
        return derivat;
    }

    public static void main(String[] args) {
        /* int q = 1; */
        System.out.println("Enter the number of points");
        int[] v = readLine();
        Vector<Vector<Integer>> points = new Vector<>();
        Vector<Integer> p1 = readPoints();
        Vector<Integer> p2 = readPoints();
        Vector<Integer> p3 = readPoints();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        if (checkPoint(v, p1) == 1) {
            System.out.println("Point is on the plane");
        } else {
            System.out.println("Point is not on the plane");
        }
        System.out.printf("Result colinear: %d\n",colinearCheck(p1, p2, p3));
        /* removePoints(q, points);
        for (int i = 0; i < points.size(); i++) {
            System.out.print(points.get(i));
        } */
        translatePoints(points);
        for (int i = 0; i < points.size(); i++) {
            System.out.print(points.get(i));
        }
    }
}
