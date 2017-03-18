package kb.sorting;

/**
 * Created by Karlo on 2017-03-17.
 */
public class QuickSort {

    public static void sort(int[] arrayToSort) {
        if (arrayToSort == null || arrayToSort.length == 0) {
            return;
        }
        int n = arrayToSort.length;
        quickSort(arrayToSort, 0, n - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotValue = array[right]; // choosing pivot as the last element of given array;

        int less = left; // left side start point, we want smaller values than pivot
        int more = right; // right side start point, we want greater values than pivot
        while (less <= more) {
            while (array[less] < pivotValue) {
                less++;
            }
            while (array[more] > pivotValue) {
                more--;
            }
            if (less <= more) {
                SortUtils.swap(array, less, more);
                less++;
                more--;
            }
        }

        if (more > left) {
            quickSort(array, left, more);
        }
        if (less < right) {
            quickSort(array, less, right);
        }

    }

}
