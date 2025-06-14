package algorithms.sorting;

import java.util.Arrays;
/* Selection Sort works by repeatedly selecting the minimum (or maximum) element
   from the unsorted portion of the list and swapping it with the first
   unsorted element. O(n^2)*/
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {1,5,6,7,3,4,8,9,1};
        sortBySelection(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortBySelection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    swap(i, j, arr);
                }
            }
        }
    }

    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
