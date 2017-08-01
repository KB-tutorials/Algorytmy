<<<<<<< HEAD
package kb.sorting;

public class QuickSort {
	
	public static void sort(int[]arrayToSort){
		if(arrayToSort == null || arrayToSort.length == 0){
			return;
		}
		int n = arrayToSort.length;
		quickSort(arrayToSort, 0, n - 1);
	}
	
	private static void quickSort(int[]array, int left, int right){
		if(left >= right){
			return;
		}
		//insert sort
		
		int border = partitionArray(array, left, right);
		
		if(border - left < right - border){
			quickSort(array, left, border - 1);
			quickSort(array, border + 1, right);
		}else{
			quickSort(array, border + 1, right);
			quickSort(array, left, border - 1);
		}
		
	}
	
	private static int partitionArray(int[]array, int left, int right){
		int pivotValue = choosePivot(array, left, right);
		int border = left - 1;
		int i = left;
		
		while(i < right){
			if(array[i] < pivotValue){
				border++;
				if(border != i){
					SortUtils.swap(array, border, i);
				}
			}
			i++;
		}
		
		border++;
		if(border != right){
			SortUtils.swap(array, border, right);
		}
		
		return border;
	}
	
	// choose pivot and move it to right index
	private static int choosePivot(int[]array, int left, int right){
		int mid = left + (right - left) / 2;
		int pivotValue = array[mid];
		SortUtils.swap(array, mid, right);
		return pivotValue;
	}
}
=======
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

        //here we can add condition for insertion sort if (right - left < ex. 10){
        //                                                 InsertionSort.sortPartOfArray(array, left, right);
        //                                             }

        int border = partitionArray(array, left, right);

        if (border - left < right - border) { // left subarray smaller than right one
            quickSort(array, left, border - 1); // sort smaller subpart first
            quickSort(array, border + 1, right);
        } else {
            quickSort(array, border + 1, right);
            quickSort(array, left, border - 1);
        }
    }

    /**
     * performs partitioning job of quicksort
     *
     * @return index of border ( where pivot lands at the end)
     */
    private static int partitionArray(int[] array, int left, int right) {
        int pivotValue = array[right];
        int border = left - 1; // border at very beginning
        int i = left;

        while (i < right) {
            if (array[i] < pivotValue) {
                border++; //move border
                if (border != i) {
                    SortUtils.swap(array, border, i);
                }
            }
            i++;
        }

        border++; // now border points to place where pivot value should land, no need to sort that element anymore
        if (border != right) {
            SortUtils.swap(array, border, right); // moving pivot to its sorted position
        }

        return border;
    }

    /**
     * choosing pivot and moving it to the end of given range of array ( at right index)
     * @return choosen pivot value
     */
    private static int choosePivot(int[] array, int left, int right) {
        int middle = left + (right - left) / 2; // pivot choosen in middle
        int pivotValue = array[middle];
        SortUtils.swap(array, right, middle); // moving pivot to end (right index)
        return pivotValue;
    }


}
>>>>>>> 81348c4f005360cd5bb62ab69b8fd6e151699c80
