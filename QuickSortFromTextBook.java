import java.util.Arrays;
import java.util.Random;
public class QuickSortFromTextBook {

    public static void quickSort(int[] A, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(A, start, end);
            quickSort(A, start, pivotIndex - 1);
            quickSort(A, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] A, int start, int end) {
        // Choose an arbitrary element A[end] to be the pivot
        int pivot;
        Random random = new Random();
        pivot = A[random.nextInt(A.length)];

        int L = start - 1;
        for (int i = start; i < end; i++) {
            if (A[i] <= pivot) {
                L++;
                // Swap A[L] and A[i]
                int temp = A[L];
                A[L] = A[i];
                A[i] = temp;
            }
        }

        // Swap A[L+1] and A[end]
        int temp = A[L + 1];
        A[L + 1] = A[end];
        A[end] = temp;

        return L + 1;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
