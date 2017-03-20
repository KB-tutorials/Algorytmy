package kb.sorting;

/**
 * Created by Karlo on 2017-03-18.
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
        // if one or less element we are done
        if (left >= right) {
            return;
        }

        //here we can add condition for insertion sort if (right - left < preference).

        int pivotValue = array[right];
        int border = left - 1; // border at very beginning
        int i = left;

        while (i < right) {
            if (array[i] < pivotValue) {
                border++; //move border
                if (border != i) {
                    SortUtils.swap(array, border, i); // can be one liner ++border
                }
            }
            i++;
        }

        border++; // now border points to place where pivot value should land, no need to sort that element anymore
        if (border != right) {
            SortUtils.swap(array, border, right); // moving pivot to its sorted position
        }

        if (border - left < right - border) { // left subarray smaller than right one
            quickSort(array, left, border - 1); // sort smaller subpart first
            quickSort(array, border + 1, right);
        } else {
            quickSort(array, border + 1, right);
            quickSort(array, left, border - 1);
        }
    }

    /*
    choosing pivot and moving it to the end of array
     */
    private static int choosePivot(int[] array, int left, int right) {
        int middle = left + (right - left) / 2; // pivot choosen in middle
        int pivotValue = array[middle];
        SortUtils.swap(array, right, middle);
        return pivotValue;
    }

}
