package kb.sorting;

public class SortUtils {

    public static void swap(int[] arr, int index1, int index2) {
        try {
            if (index1 != index2) {
                int temp = arr[index1];
                arr[index1] = arr[index2];
                arr[index2] = temp;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index for given array!\n" + e.getMessage());
        }
    }

}
