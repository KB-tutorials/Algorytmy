package kb.sorting;

import java.util.Arrays;
import java.util.Random;

public class TestOfSorting {

    public static void main(String[] args) {
        Random r = new Random();
        int size = 100;
        int[] testArray = new int[size];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = r.nextInt(size + 10);
        }
        int[] testArray2 = Arrays.copyOf(testArray, testArray.length); // for object use DEEP COPY
        int[] testArray3 = Arrays.copyOf(testArray, testArray.length);

        System.out.println("BUBBLE SORT");
        //TestOfSorting.printArray(testArray);
        long start = System.currentTimeMillis();

        // BubbleSort.sort(testArray);

        System.out.println(System.currentTimeMillis() - start);
        //TestOfSorting.printArray(testArray);

        System.out.println();

        System.out.println();
        System.out.println("QUICK SORT");
        TestOfSorting.printArray(testArray3);
        start = System.currentTimeMillis();

        QuickSort.sort(testArray3);

        System.out.println(System.currentTimeMillis() - start);
        TestOfSorting.printArray(testArray3);

    }

    private static void printArray(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
}
