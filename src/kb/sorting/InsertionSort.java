package kb.sorting;

public class InsertionSort {
	public static void sort(int[]arr){
		if(arr == null || arr.length == 0){
			return;
		}
		int n = arr.length;
		int current;
		int otherIndex;
		for(int i = 1; i < n; i++){
			current = arr[i];
			otherIndex = i;
			while(otherIndex > 0 && current < arr[otherIndex - 1]){
				arr[otherIndex] = arr[otherIndex - 1];
				otherIndex--;
			}
			arr[otherIndex] = current;
		}
	}

	public static void sortPartOfArray(int[]array, int left, int right){
		if(array == null || array.length == 0){
			return;
		}
		int current;
		int otherIndex;
		for(int i = left + 1; i <= right; i++){
			current = array[i];
			otherIndex = i;
			while(otherIndex > left && current < array[otherIndex - 1]){
				array[otherIndex] = array[otherIndex - 1];
				otherIndex--;
			}
			array[otherIndex] = current;
		}
	}
}
