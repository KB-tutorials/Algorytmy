package kb.sorting;

public class SelectSort {
	
	public static void sort(int[]arrayToSort){
		if(arrayToSort == null || arrayToSort.length == 0){
			return;
		}
		int n = arrayToSort.length;
		int minIndex;
		for(int i = 0; i < n - 1; i++){
			minIndex = i;
			for(int j = i + 1; j < n; j++){
				if(arrayToSort[j] < arrayToSort[minIndex]){
					minIndex = j;
				}
			}
			if(minIndex != i){
				SortUtils.swap(arrayToSort, minIndex, i);
			}
		}
	}
}
