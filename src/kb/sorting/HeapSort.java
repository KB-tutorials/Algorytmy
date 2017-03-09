package kb.sorting;

public class HeapSort {
	
	public static void sort(int[]arrayToSort){
		int n = arrayToSort.length;
		
		for(int i = n / 2 - 1; i >= 0; i--){
			HeapSort.validateMaxHeap(arrayToSort, n, i);
		}
		
		for(int i = n - 1; i > 0; i--){
			SortUtils.swap(arrayToSort, 0, i);
			--n;
			HeapSort.validateMaxHeap(arrayToSort, n, 0);
		}
	}
	
	private static void validateMaxHeap(int[]array, int heapSize, int parentIndex){
		int maxIndex = parentIndex;
		int leftChild = parentIndex * 2 + 1;
		int rightChild = parentIndex * 2 + 2;
		
		if(leftChild < heapSize && array[leftChild] > array[maxIndex]){
			maxIndex = leftChild;
		}
		if(rightChild < heapSize && array[rightChild] > array[maxIndex]){
			maxIndex = rightChild;
		}
		if(maxIndex != parentIndex){
			SortUtils.swap(array, maxIndex, parentIndex);
			HeapSort.validateMaxHeap(array, heapSize, maxIndex);
		}
	} 
	
}
