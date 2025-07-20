package arrays;

import java.util.Arrays;

public class RightRotation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        rightRotateByK(arr, 4);
        System.out.println(Arrays.toString(arr));
    }

    private static void rightRotateByK(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
    }

    private static void reverseArray(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
