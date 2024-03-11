import java.util.Arrays;
import java.util.Random;


public class QuickSortFromHW2 {

    public static void quickSort(int[] A, int start, int end) {
        if (start < end) {
            int p = choosePivotIndex(A, start, end);
            int r = partition(A, start, end, p);

            quickSort(A, start, r - 1);
            quickSort(A, r + 1, end);
        }
    }

    private static int choosePivotIndex(int[] A, int start, int end) {
        // Choose pivot index, for simplicity, just use the last element
        Random random = new Random();
        int randomPivotElement = A[random.nextInt(A.length)];
        return randomPivotElement;
    }

    private static int partition(int[] A, int start, int end, int p) {
        int pivot = A[p];
        int[] AL = new int[end - start + 1];
        int[] AR = new int[end - start + 1];
        int indexAL = 0, indexAR = 0;

        for (int i = start; i <= end; i++) {
            if (i != p) {
                if (A[i] < pivot) {
                    AL[indexAL++] = A[i];
                } else {
                    AR[indexAR++] = A[i];
                }
            }
        }

        // Concatenate AL, pivot, and AR
        for (int i = 0; i < indexAL; i++) {
            A[start + i] = AL[i];
        }
        int pivotIndex = start + indexAL;
        A[pivotIndex] = pivot;
        for (int i = 0; i < indexAR; i++) {
            A[pivotIndex + 1 + i] = AR[i];
        }

        return pivotIndex;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}