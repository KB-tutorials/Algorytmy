package kb.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class ShellSort {
	
	public static void sort(int[]arr, Function<Integer, Integer[]> distGenerator){
		int n = arr.length;
		int iter = 1;
		Integer[] distances = distGenerator.apply(n);
		int distance = distances[distances.length - iter];
		int current, otherIndex;
		while(distance >= 1){
			for(int i = distance; i < n; i++){
				current = arr[i];
				otherIndex = i;
				while(otherIndex >= distance && current < arr[otherIndex - distance]){
					arr[otherIndex] = arr[otherIndex - distance];
					otherIndex -= distance;
				}
				arr[otherIndex] = current;
			}
			distance = distances[distances.length - ++iter];
		}
	}
	
	public static Integer[] shellDistance(int numberOfElements){
		ArrayList<Integer> distances = new ArrayList<>();
		int iteration = 1;
		int generated;
		do{
			generated = numberOfElements / (int)Math.pow(2, iteration);
			distances.add(generated);
			iteration++;
		}while(generated > 0);
		Collections.reverse(distances);
		return distances.toArray(new Integer[distances.size()]);
	}
	
	// 4^k + 3*2^(k-1) + 1 
	public static Integer[] sedgewickDistance(int numberOfElements){
		int generated = 0;
		ArrayList<Integer> distances = new ArrayList<>();
		int k = 0;
		while(generated < numberOfElements){
			if(distances.isEmpty()){
				distances.add(0);
				distances.add(1);
			} else{
				generated = (int) (Math.pow(4, k) + 3 * Math.pow(2, k-1) + 1);
				if(generated < numberOfElements){
					distances.add(generated);
				}
			}
			k++;
		}
		return distances.toArray(new Integer[distances.size()]);
	}
	
}
