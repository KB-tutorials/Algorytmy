package kb.sorting;

public class InsertionSort {
	public static void sort(int[]arr){
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
}
