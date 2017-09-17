package pengliu.cf.newSort;

import java.util.Arrays;

/**
 * Created by peng on 9/17/17.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] input = {4, 1, 5, 0, 2, -1};
        mergeSort(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{4, 1, 5};
        mergeSort(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{6, 5};
        mergeSort(input);
        System.out.println(Arrays.toString(input));
    }

    private static void merge(int[] a, int[] temp, int left, int mid, int right) {
        int i = left, j = mid+1, k = left;
        while(i <= mid && j <= right) {
            if(temp[i] < temp[j]) {
                a[k++] = temp[i++];
            }
            else {
                a[k++] = temp[j++];
            }
        }

        while(i <= mid) {
            a[k++] = temp[i++];
        }
        while(j <= mid) {
            a[k++] = temp[j++];
        }

        //必须要将排好序的数组内容拷贝回temp数组，以便后续的归并是继续排好序的temp数组，而不是原封没动的temp数组
        for(i = left; i <= right; i++) {
            temp[i] = a[i];
        }
    }

    private static void mergeSort(int[] a, int[] temp, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(a, temp, start, mid);
        mergeSort(a, temp,  mid + 1, end);
        merge(a, temp, start, mid, end);
    }

    public static void mergeSort(int[] a) {
        if(a == null) {
            return;
        }
        int[] temp = new int[a.length];
        for(int i=0; i<a.length; i++) {
            temp[i] = a[i];
        }
        mergeSort(a, temp, 0, a.length - 1);
    }
}
