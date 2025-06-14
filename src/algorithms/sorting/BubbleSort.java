package algorithms.sorting;

import java.util.Arrays;

/* It works by repeatedly swapping the adjacent elements if they
   are in the wrong order. The largest elements "bubble" up to their
   correct position after each pass. O(n^2) */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 7, 3, 4, 8, 9, 1};
        sortByBubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortByBubble(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                }
            }
        }
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
