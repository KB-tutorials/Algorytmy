package kb.sorting;

public class BubbleSort {
	
	public static void sort(int[]arrayToSort){
		int n = arrayToSort.length;
		int it = 0;
		boolean swapped = true;
		while(it < n - 1 && swapped){
			swapped = false;
			for(int j = 0; j < n - 1 - it; j++){
				if(arrayToSort[j] > arrayToSort[j + 1]){
					swap(arrayToSort, j, j+1);
					swapped = true;
				}
			}
			it++;
		}
	}
	
	private static void swap(int[]arr, int index1, int index2){
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
