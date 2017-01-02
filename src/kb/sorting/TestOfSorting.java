package kb.sorting;

import java.util.Arrays;
import java.util.Random;

public class TestOfSorting {
	
	public static void main(String[]args){
		Random r = new Random();
		int[]testArray = new int[1000];
		for(int i = 0; i < testArray.length; i++){
			testArray[i] = r.nextInt(1000);
		}
		int[]testArray2 = Arrays.copyOf(testArray, testArray.length); // for object use DEEP COPY
		
		TestOfSorting.printArray(testArray);
		long start = System.currentTimeMillis();
		
		BubbleSort.sort(testArray);
		
		System.out.println(System.currentTimeMillis() - start);
		TestOfSorting.printArray(testArray);
		
		System.out.println("SELECT SORT");
		
		TestOfSorting.printArray(testArray2);
		long start2 = System.currentTimeMillis();
		
		SelectSort.sort(testArray2);
		
		System.out.println(System.currentTimeMillis() - start2);
		TestOfSorting.printArray(testArray2);
		
	}
	
	private static void printArray(int[]arr){
		for(int j = 0; j < arr.length; j++){
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}
}
