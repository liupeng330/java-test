package pengliu.cf.newSort;

import java.util.Arrays;

/**
 * Created by peng on 9/17/17.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] input = {4, 1, 5, 0, 2, -1};
        insertSort(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{4, 1, 5};
        insertSort(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{6, 5};
        insertSort(input);
        System.out.println(Arrays.toString(input));
    }

    private static void insertSort(int[] arr) {
        if(arr == null) {return;}
        for(int i=1; i<arr.length; i++) {
            int temp = arr[i];
            int j;
            for(j = i; j-1 >= 0 && arr[j-1] > temp; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }
}
