package Algorithms.lab3;

public class merge1d {
    public static void merge(int[] a, int[] b, int[] c, int n, int m) {
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        // Copy remaining elements of a[] if any
        while (i < n) {
            c[k++] = a[i++];
        }
        // Copy remaining elements of b[] if any
        while (j < m) {
            c[k++] = b[j++];
        }
    }
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = {2, 4, 6, 8, 10};
        int n = a.length;
        int m = b.length;
        int[] c = new int[n + m];

        merge(a, b, c, n, m);

        System.out.println("Merged array:");
        printArray(c);
    }
}
