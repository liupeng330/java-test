package pengliu.cf.newSort;

import java.util.Arrays;

/**
 * Created by peng on 9/17/17.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] input = {4, 1, 5, 0, 2, -1};
        quickSort(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{4, 1, 5};
        quickSort(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{6, 5};
        quickSort(input);
        System.out.println(Arrays.toString(input));
    }

    private static int partition(int[] a, int low, int high) {
        int p = getPivot(a, low, high);
        int i= low + 1;
        int j = high;
        while(true) {
            while(a[++i] < p) {}
            while(a[--j] > p) {}
            if(i > j) break;
            exchange(a, i, j);
        }
        exchange(a, low+1, j);
        return j;
    }

    private static int getPivot(int[] a, int start, int end) {
        int mid = (start + end) / 2;
        if(a[start] > a [mid]) {
            exchange(a, start, mid);
        }
        if(a[mid] > a [end]) {
            exchange(a, end, mid);
        }
        if(a[start] > a [mid]) {
            exchange(a, start, mid);
        }
        exchange(a, start + 1, mid);
        return a[start + 1];
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void quickSort(int[] a, int start, int end) {
        if(start >= end) return;
        int p = partition(a, start, end);
        quickSort(a, start, p - 1);
        quickSort(a, p + 1, end);
    }

    public static void quickSort(int[] a) {
        if(a == null || a.length == 1) {return;}
        if(a.length == 2) {
            if(a[0] > a[1]) {
                exchange(a, 0, 1);
            }
            return;
        }

        quickSort(a, 0, a.length - 1);
    }
}
