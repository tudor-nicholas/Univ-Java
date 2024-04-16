package Algorithms.lab3;

public class merge1array {
    public static void mergeSort(int[] v, int[] w, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(v, w, left, mid);
            mergeSort(v, w, mid + 1, right);
            merge(v, w, left, mid, right);
        }
    }

    public static void merge(int[] v, int[] w, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (v[i] <= v[j]) {
                w[k++] = v[i++];
            } else {
                w[k++] = v[j++];
            }
        }

        while (i <= mid) {
            w[k++] = v[i++];
        }

        while (j <= right) {
            w[k++] = v[j++];
        }

        for (i = 0; i < k; i++) {
            v[i + left] = w[i];
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] v = {12, 11, 13, 5, 6, 7};
        int[] w = new int[v.length];

        System.out.println("Original array:");
        printArray(v);

        mergeSort(v, w, 0, v.length - 1);

        System.out.println("Sorted array:");
        printArray(v);
    }
}
