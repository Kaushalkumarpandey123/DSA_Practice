package algorithms.sorting;

import java.util.Arrays;

/* It works by iteratively inserting each element of an unsorted
   list into its correct position in a sorted portion of the list. O(n^2) */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 7, 3, 4, 8, 9, 2, 1};
        sortByInsertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortByInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while ( j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
